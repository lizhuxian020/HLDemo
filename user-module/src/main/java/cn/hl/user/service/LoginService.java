package cn.hl.user.service;

import cn.hl.user.model.dto.UserLoginDTO;
import cn.hl.user.model.dto.UserRegisterDTO;
import cn.hl.user.model.entity.UserAccountEntity;
import cn.hl.user.model.vo.UserLoginVO;
import com.baomidou.mybatisplus.extension.service.IService;

public interface LoginService extends IService<UserAccountEntity> {

    UserLoginVO login(UserLoginDTO userLoginDTO);

    boolean registerAccount(UserRegisterDTO userRegisterDTO);
}
