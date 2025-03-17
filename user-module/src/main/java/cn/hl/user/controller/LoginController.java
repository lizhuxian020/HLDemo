package cn.hl.user.controller;

import cn.hl.common.model.CallResult;
import cn.hl.user.model.dto.UserLoginDTO;
import cn.hl.user.model.vo.UserLoginVO;
import cn.hl.user.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public CallResult<UserLoginVO> login(@RequestBody UserLoginDTO loginDTO) {
        UserLoginVO loginVO = loginService.login(loginDTO);
        return CallResult.success(loginVO);
    }
}
