package cn.hl.user.service;

import cn.hl.common.model.dto.PageDTO;
import cn.hl.user.model.dto.UserLoginDTO;
import cn.hl.user.model.dto.UserRegisterDTO;
import cn.hl.user.model.entity.UserAccountEntity;
import cn.hl.user.model.vo.UserInfoVO;
import cn.hl.user.model.vo.UserLoginVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface LoginService extends IService<UserAccountEntity> {

    UserLoginVO login(UserLoginDTO userLoginDTO);

    boolean registerAccount(UserRegisterDTO userRegisterDTO);

    boolean userUpdate(UserRegisterDTO userRegisterDTO);

    IPage<UserInfoVO> listOfUserInfo(PageDTO pageDTO);

    UserInfoVO userWithId(Integer id);
}
