package cn.hl.common.model.exception;

import lombok.Getter;

@Getter
public enum HLReturnCode {

    BASE_TOKEN_UNAUTHORIZED(401, "请重新登录"),
    BASE_ILLEGAL_PARAM(411, "无效参数"),
    USER_LOGIN_REGISTER_DUPLICATION(422, "账号已存在"),
    USER_LOGIN_ACCOUNT_NOT_MATCH(423, "账号不存在或密码错误"),
    USER_CAN_NOT_FIND_USER(424, "找不到用户"),


    ;

    private final Integer code;
    private final String message;

    HLReturnCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
