package cn.hl.user.controller;

import cn.hl.common.model.CallResult;
import cn.hl.user.model.dto.UserLoginDTO;
import cn.hl.user.model.dto.UserRegisterDTO;
import cn.hl.user.model.vo.UserLoginVO;
import cn.hl.user.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    @RequestMapping("/login")
    public CallResult<UserLoginVO> login(@RequestBody UserLoginDTO loginDTO) {
        UserLoginVO loginVO = loginService.login(loginDTO);
        return CallResult.success(loginVO);
    }

    @PostMapping
    @RequestMapping("/register")
    public CallResult<Boolean> register(@RequestBody UserRegisterDTO userRegisterDTO) {
        return CallResult.success(loginService.registerAccount(userRegisterDTO));
    }
}
