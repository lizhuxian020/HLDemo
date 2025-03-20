package cn.hl.common.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class CallResult<T> implements Serializable {

    public static final int SUCCESS_CODE = 0;
    public static final String SUCCESS_MSG = "success";
    public static final int ERROR_CODE = -1;
    public static final String ERROR_MSG = "error";

    private int code;
    private String message;
    private T data;

    public CallResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> CallResult success(T data) {
        return new CallResult(SUCCESS_CODE, SUCCESS_MSG, data);
    }

    public static CallResult error(int code, String message) {
        return new CallResult(code, message, "");
    }

}
