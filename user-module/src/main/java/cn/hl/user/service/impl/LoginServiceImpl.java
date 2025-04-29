package cn.hl.user.service.impl;

import cn.hl.common.config.JwtConfig;
import cn.hl.common.model.exception.HLReturnCode;
import cn.hl.common.model.exception.HLRunTimeException;
import cn.hl.common.model.jwt.TokenMessage;
import cn.hl.user.dao.UserAccountDao;
import cn.hl.user.model.dto.UserLoginDTO;
import cn.hl.user.model.dto.UserRegisterDTO;
import cn.hl.user.model.entity.UserAccountEntity;
import cn.hl.user.model.vo.UserInfoVO;
import cn.hl.user.model.vo.UserLoginVO;
import cn.hl.user.service.LoginService;
import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoginServiceImpl extends ServiceImpl<UserAccountDao, UserAccountEntity> implements LoginService {

    @Resource
    private JwtConfig jwtConfig; //TOResolv: 为啥Autowire会报错

    @Override
    public UserLoginVO login(UserLoginDTO userLoginDTO) {
        UserLoginVO loginVO = new UserLoginVO();
        LambdaQueryWrapper<UserAccountEntity> wrapper = new LambdaQueryWrapper<UserAccountEntity>()
                .eq(UserAccountEntity::getAccount, userLoginDTO.getAccount())
                .eq(UserAccountEntity::getPassword, userLoginDTO.getPassword());
        UserAccountEntity userAccountEntity = this.baseMapper.selectOne(wrapper);
        if (userAccountEntity == null) {
            throw new HLRunTimeException(HLReturnCode.USER_LOGIN_ACCOUNT_NOT_MATCH);
        }
        TokenMessage tokenMessage = new TokenMessage();
        tokenMessage.setRealName(userAccountEntity.getRealName());
        tokenMessage.setUserAccount(userAccountEntity.getAccount());
        tokenMessage.setUserId(userAccountEntity.getUserId());
        String jwtToken = jwtConfig.generateToken(JSON.toJSONString(tokenMessage));
        loginVO.setToken(jwtToken);
        loginVO.setUserId(userAccountEntity.getUserId());
        return loginVO;
    }

    @Override
    public boolean registerAccount(UserRegisterDTO userRegisterDTO){
        //检查该账号是否存在
        LambdaQueryWrapper<UserAccountEntity> wrapper = new LambdaQueryWrapper<UserAccountEntity>().eq(UserAccountEntity::getAccount, userRegisterDTO.getAccount());
        UserAccountEntity userAccountEntity = this.baseMapper.selectOne(wrapper);
        if (userAccountEntity != null) {
            throw new HLRunTimeException(HLReturnCode.USER_LOGIN_REGISTER_DUPLICATION);
        }
        UserAccountEntity userEntity = new UserAccountEntity();
        userEntity.setAccount(userRegisterDTO.getAccount());
        userEntity.setPassword(userRegisterDTO.getPassword());
        boolean save = this.save(userEntity);
        return save;
    }

    @Override
    public List<UserInfoVO> listOfUserInfo() {
        List<UserAccountEntity> userAccountEntities = this.baseMapper.selectList(new LambdaQueryWrapper<UserAccountEntity>());
        List<UserInfoVO> list = new ArrayList<>();
        for (UserAccountEntity entity : userAccountEntities) {
            UserInfoVO infoVO = new UserInfoVO();
            BeanUtil.copyProperties(entity, infoVO);
            list.add(infoVO);
        }
        return list;
    }


}
