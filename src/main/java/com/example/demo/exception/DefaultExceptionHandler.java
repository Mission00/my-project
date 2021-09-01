package com.example.demo.exception;

import com.example.demo.result.Result;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class DefaultExceptionHandler {
//    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handleAuthorizationException(Exception e) {
        if(e instanceof UnauthorizedException){
            String message = "权限认证失败";
            System.out.println(message);
            Result result = new Result(400);
            result.setData(message);
            return result;
        }
        return null;

    }
}
