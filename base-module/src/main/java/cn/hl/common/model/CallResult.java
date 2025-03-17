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

    public static <T> CallResult success(T data) {
        CallResult<T> callResult = new CallResult();
        callResult.code = SUCCESS_CODE;
        callResult.message = SUCCESS_MSG;
        callResult.data = data;
        return callResult;
    }

}
