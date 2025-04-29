package cn.hl.user.controller;

import cn.hl.common.model.CallResult;
import cn.hl.common.model.dto.PageDTO;
import cn.hl.user.model.dto.UserLoginDTO;
import cn.hl.user.model.dto.UserRegisterDTO;
import cn.hl.user.model.vo.UserInfoVO;
import cn.hl.user.model.vo.UserLoginVO;
import cn.hl.user.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

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
        return CallResult.successBool(loginService.registerAccount(userRegisterDTO));
    }

    @PostMapping("/list")
    public CallResult getPages(@RequestBody PageDTO pageDTO) {
        return CallResult.success(loginService.listOfUserInfo(pageDTO));
    }

    @GetMapping("/id/{id}")
    public CallResult getById(@PathVariable Integer id) {
        return CallResult.success(loginService.userWithId(id));
    }

    @PostMapping
    @RequestMapping("/update")
    public CallResult<Boolean> update(@RequestBody UserRegisterDTO userRegisterDTO) {
        return CallResult.successBool(loginService.userUpdate(userRegisterDTO));
    }
}
