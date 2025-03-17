package cn.hl.user.service;

import cn.hl.user.model.dto.UserLoginDTO;
import cn.hl.user.model.vo.UserLoginVO;

public interface LoginService {

    UserLoginVO login(UserLoginDTO userLoginDTO);
}
