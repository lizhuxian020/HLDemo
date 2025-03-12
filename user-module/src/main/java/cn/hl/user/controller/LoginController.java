package cn.hl.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user/login")
public class LoginController {

    @PostMapping
    public String login(String account) {
        System.out.println("get account: " + account);
        return account;
    }

    @GetMapping("/asd")
    public String test() {
        return "account";
    }
}
