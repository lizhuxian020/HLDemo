package cn.hl.user.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRegisterDTO implements Serializable {

    private Integer userId;
    private String account;
    private String password;
    private String realName;
}
