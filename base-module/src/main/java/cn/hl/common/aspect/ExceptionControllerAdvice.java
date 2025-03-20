package cn.hl.common.aspect;

import cn.hl.common.model.CallResult;
import cn.hl.common.model.exception.HLRunTimeException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(HLRunTimeException.class)
    public CallResult processRuntimeException(HLRunTimeException exception) {
        return CallResult.error(exception.getCode(), exception.getMessage());
    }
}
