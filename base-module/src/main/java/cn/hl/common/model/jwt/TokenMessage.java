package cn.hl.common.model.jwt;

import lombok.Data;

@Data
public class TokenMessage {

    private Integer userId;
    private String userAccount;
    private String realName;

//    private Integer projectId;


}
