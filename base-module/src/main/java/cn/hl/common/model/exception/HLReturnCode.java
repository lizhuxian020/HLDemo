package cn.hl.common.model.exception;

import lombok.Getter;

@Getter
public enum HLReturnCode {

    USER_LOGIN_REGISTER_DUPLICATION_ERROR(401, "账号已存在"),

    ;

    private final Integer code;
    private final String message;

    HLReturnCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
