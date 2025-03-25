package cn.hl.user.model.dto;

import lombok.Data;

@Data
public class UserLoginDTO {

    private String account;
    private String password;
    private String realName;
}
