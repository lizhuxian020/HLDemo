package cn.hl.common.model.exception;

import lombok.Getter;

@Getter
public enum HLReturnCode {

    BASE_TOKEN_UNAUTHORIZED(401, "未授权"),
    USER_LOGIN_REGISTER_DUPLICATION(402, "账号已存在"),


    ;

    private final Integer code;
    private final String message;

    HLReturnCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
