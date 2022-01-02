package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.pojo.Admin;
import com.example.demo.result.Result;
import com.example.demo.service.AdminService;
import com.example.demo.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;
import org.apache.shiro.subject.Subject;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
@CrossOrigin
@RestController
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private AdminService adminService;
    @CrossOrigin
    @PostMapping(value = "/api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser, HttpSession session)
    {
        String username = requestUser.getUsername();

        username = HtmlUtils.htmlEscape(username);
        String password = requestUser.getPassword();
        User user = userService.selectUserByUserNameAndPassword(username,password);
        Result result;
        if(user == null)
        {
            return new Result(400);
        }
        else
        {
            Map<String,Object> map = new HashMap<String,Object>();
            result =new Result(200);
            //result.setCode(200);
            map.put("userid",user.getId());
            map.put("username",user.getUsername());
            System.out.println(map.get("userid"));
            session.setAttribute("user",user);
            result.setData(map);
            //return new Result(200);
        }
        return result;
    }

    @CrossOrigin
    @PostMapping(value = "api/admin/login")
    @ResponseBody
    public Result adminLoginResult(@RequestBody Admin requestAdmin){
        String adminname = requestAdmin.getAdminname();

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(adminname, requestAdmin.getPassword());

        try {
            subject.login(usernamePasswordToken);
        } catch (AuthenticationException e) {
            String message = "账号密码错误";
            System.out.println(message);
        }

        String password = requestAdmin.getPassword();
        System.out.println(adminname+password);
        Admin admin = adminService.selectAdminByAdminNameAndPassword(adminname,password);
        System.out.println(admin);
        Result result;
        if(admin==null){
            return new Result(400);
        }else if(!admin.getisUsed()){
            return new Result(-1);
        } else{
            Map<String,Object> map = new HashMap<>();
            result = new Result(200);
            map.put("adminid",admin.getId());
            map.put("adminname",admin.getAdminname());
            result.setData(map);
        }
        return result;
    }


    @ResponseBody
    @GetMapping("api/logout")
    public Result logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        String message = "成功登出";
        Result result = new Result(200);
        result.setData(message);
        return result;
    }

    @ResponseBody
    @GetMapping("api/admin/logout")
    public Result adminLogout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        String message = "成功登出";
        Result result = new Result(200);
        result.setData(message);
        return result;
    }

    @ResponseBody
    @GetMapping(value = "api/admin/authentication")
    public String authentication(){
        String username = SecurityUtils.getSubject().getPrincipal().toString();
        System.out.println(username+"身份验证");
        return "身份认证成功";
    }
}
