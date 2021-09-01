package com.example.demo.controller;

import com.example.demo.result.Result;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController {

    @ResponseBody
    @RequestMapping("/filterError/{code}/{message}")
    public Result error(@PathVariable("code")Integer code, @PathVariable("message")String message){
        System.out.println("errorController");
        Result result = new Result(code);
        result.setData(message);
        return result;
    }
}