package com.tencent.wxcloudrun.config;

import com.tencent.wxcloudrun.vo.RestResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<RestResponse> handleAllExceptions(Exception ex) {
        // 记录日志，处理异常信息
        RestResponse restResponse = new RestResponse(101, ex.getMessage());
        return new ResponseEntity(restResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        // 记录日志，处理参数验证异常信息
        return new ResponseEntity<>("Validation failed: " + ex.getBindingResult().toString(), HttpStatus.BAD_REQUEST);
    }
}