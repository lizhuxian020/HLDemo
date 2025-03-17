package cn.hl.user.service.impl;

import cn.hl.user.model.dto.UserLoginDTO;
import cn.hl.user.model.vo.UserLoginVO;
import cn.hl.user.service.LoginService;
import cn.hl.user.util.JwtUtil;
import cn.hutool.core.lang.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

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
}
