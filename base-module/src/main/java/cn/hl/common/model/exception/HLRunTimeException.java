package cn.hl.common.model.exception;

import lombok.Data;

@Data
public class HLRunTimeException extends RuntimeException{
    private int code;
    private String message;

    public HLRunTimeException(HLReturnCode returnCode) {
        code = returnCode.getCode();
        message = returnCode.getMessage();
    }
}
