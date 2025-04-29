package cn.hl.common.model;

import cn.hl.common.model.exception.HLReturnCode;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

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

    public static CallResult successBool(Boolean data) {
        Map<String, Object> resultData = new HashMap<>();
        resultData.put("flag", data);
        return new CallResult(SUCCESS_CODE, SUCCESS_MSG, resultData);
    }

    public static CallResult error(int code, String message) {
        return new CallResult(code, message, "");
    }

    public static CallResult returnCode(HLReturnCode returnCode) {
        return new CallResult(returnCode.getCode(), returnCode.getMessage(), "");
    }

}
