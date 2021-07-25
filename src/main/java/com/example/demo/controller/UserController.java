package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.pojo.Admin;
import com.example.demo.result.Result;
import com.example.demo.service.AdminService;
import com.example.demo.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class UserController {
    
    @Autowired
    private UserService userService;
    @Autowired
    private AdminService adminService;

    @GetMapping(value = "/api/userlist")
    @ResponseBody
    public Result<List<User>> listUser(@RequestBody User requestUser)
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
            result.setData(map);
            //return new Result(200);
        }
        return result;
    }

    @GetMapping(value = "/api/adminlist")
    @ResponseBody
    public Result<List<Admin>> listAdmin(@RequestParam("pageSize") int pageSize
            ,@RequestParam("currentPage") int currentPage
            ,@RequestParam("searchMsg") String searchMsg)
    {
        List<Admin> adminList = adminService.selectAdmin(pageSize,currentPage,searchMsg);
        Result result;
        if(adminList == null){
            return new Result<>(400);
        }else{
            result = new Result(200);
            result.setData(adminList);
            result.setTotal(adminService.getTotal(searchMsg));

        }
        return result;
    }
//    @GetMapping(value = "/api/admintotol")
//    @ResponseBody
//    public int getAdminTotol(){
//        Result result;
//        int totol = adminService.getAdminTotol();
//        return totol;
//    }

    @GetMapping(value = "/api/deleteAdmin")
    @ResponseBody
    public Result deleteAdminById(@RequestParam("id") int id)
    {
        adminService.deleteAdmin(id);
        return null;
    }

    @PostMapping(value = "/api/insertAdmin")
    @ResponseBody
    public Result insertAdmin(@RequestBody Admin admin)
    {
        if(adminService.adminIsInTable(admin.getAdminname())){
            return new Result(202);
        }else {
            adminService.insertAdmin(admin);
        }
        return new Result(200);
    }

}
