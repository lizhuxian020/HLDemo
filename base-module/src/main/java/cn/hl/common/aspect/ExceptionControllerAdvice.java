package cn.hl.common.aspect;

import cn.hl.common.model.CallResult;
import cn.hl.common.model.exception.HLRunTimeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(HLRunTimeException.class)
    public CallResult processRuntimeException(HLRunTimeException exception) {
        return CallResult.error(exception.getCode(), exception.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public CallResult handleOtherException(Exception e, HttpServletResponse response) {
        e.printStackTrace();
        //这里设置了500的话, web那边会走Error, 这里正常走200就行了
//        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return CallResult.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "歇一歇, 再试试");
    }

}
