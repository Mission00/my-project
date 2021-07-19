package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.pojo.admin;
import com.example.demo.result.LoginResult;
import com.example.demo.service.AdminService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private AdminService adminService;
    @CrossOrigin
    @PostMapping(value = "/api/login")
    @ResponseBody
    public LoginResult login(@RequestBody User requestUser)
    {
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);
        String password = requestUser.getPassword();
        User user = userService.selectUserByUserNameAndPassword(username,password);
        LoginResult loginResult;
        if(user == null)
        {
            return new LoginResult(400);
        }
        else
        {
            Map<String,Object> map = new HashMap<String,Object>();
            loginResult =new LoginResult(200);
            //result.setCode(200);
            map.put("userid",user.getId());
            map.put("username",user.getUsername());
            System.out.println(map.get("userid"));
            loginResult.setData(map);
            //return new Result(200);
        }
        return loginResult;
    }

    @CrossOrigin
    @PostMapping(value = "api/admin_login")
    @ResponseBody
    public LoginResult adminLoginResult(@RequestBody admin requestAdmin){
        String username = requestAdmin.getUserName();
        String password = requestAdmin.getPassword();
        admin admin = adminService.selectAdminByUserNameAndPassword(username,password);
        LoginResult loginResult;
        if(admin!=null){
            return new LoginResult(400);
        }else{
            Map<String,Object> map = new HashMap<>();
            loginResult = new LoginResult(200);
            map.put("adminid",admin.getId());
            map.put("adminname",admin.getUserName());
            loginResult.setData(map);
        }
        return loginResult;
    }
}
