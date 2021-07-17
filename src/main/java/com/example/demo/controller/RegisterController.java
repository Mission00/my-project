package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;


@RestController
public class RegisterController {

    @Autowired
    private UserService userService;
    @CrossOrigin
    @PostMapping(value = "/api/register")
    @ResponseBody
    public int register(@RequestBody User requestUser)
    {
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);
        String password = requestUser.getPassword();
        boolean result = userService.insertUser(username,password);

        if(result)
        {
            return 200;
        }
        else
        {
            return 400;
        }
    }
}
