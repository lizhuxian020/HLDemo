package cn.hl.user.service.impl;

import cn.hl.common.model.exception.HLReturnCode;
import cn.hl.common.model.exception.HLRunTimeException;
import cn.hl.user.dao.UserLoginDao;
import cn.hl.user.model.dto.UserLoginDTO;
import cn.hl.user.model.dto.UserRegisterDTO;
import cn.hl.user.model.entity.UserAccountEntity;
import cn.hl.user.model.vo.UserLoginVO;
import cn.hl.user.service.LoginService;
import cn.hl.common.util.JwtUtil;
import cn.hutool.core.lang.UUID;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl extends ServiceImpl<UserLoginDao, UserAccountEntity> implements LoginService {

    @Value("${jwt.privateKye:213123}")
    private String jwtPrivateKey;

    @Override
    public UserLoginVO login(UserLoginDTO userLoginDTO) {
        UserLoginVO loginVO = new UserLoginVO();
        String key = UUID.fastUUID().toString().replaceAll("-", "");
        String jwtToken = JwtUtil.createJwtToken(key, jwtPrivateKey, userLoginDTO.getAccount());
        loginVO.setToken(jwtToken);
        return loginVO;
    }

    @Override
    public boolean registerAccount(UserRegisterDTO userRegisterDTO){
        //检查该账号是否存在
        LambdaQueryWrapper<UserAccountEntity> wrapper = new LambdaQueryWrapper<UserAccountEntity>().eq(UserAccountEntity::getAccount, userRegisterDTO.getAccount());
        UserAccountEntity userAccountEntity = this.baseMapper.selectOne(wrapper);
        if (userAccountEntity != null) {
            throw new HLRunTimeException(HLReturnCode.USER_LOGIN_REGISTER_DUPLICATION_ERROR);
        }
        UserAccountEntity userEntity = new UserAccountEntity();
        userEntity.setAccount(userRegisterDTO.getAccount());
        userEntity.setPassword(userRegisterDTO.getPassword());
        boolean save = this.save(userEntity);
        return save;
    }


}
