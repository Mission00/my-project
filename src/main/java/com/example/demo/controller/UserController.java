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

    @GetMapping(value = "/api/admin/userlist")
    @ResponseBody
    public Result listUser(@RequestParam("pageSize") int pageSize
            ,@RequestParam("currentPage") int currentPage
            ,@RequestParam("searchMsg") String searchMsg)
    {
        List<User> userList = userService.selectUser(pageSize,currentPage,searchMsg);
        Result result;
        if(userList == null){
            return new Result<>(400);
        }else{
            result = new Result(200);
            result.setData(userList);
            result.setTotal(userService.getTotal(searchMsg));
        }
        return result;
    }

    @GetMapping(value = "/api/admin/adminlist")
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

    @GetMapping(value = "/api/admin/deleteAdmin")
    @ResponseBody
    public Result deleteAdminById(@RequestParam("id") int id)
    {
        adminService.deleteAdmin(id);
        return null;
    }

    @GetMapping(value = "/api/admin/deleteUser")
    @ResponseBody
    public Result deleteUserById(@RequestParam("id") int id)
    {
        userService.deleteUser(id);
        return null;
    }

    @PostMapping(value = "/api/admin/insertAdmin")
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

    @PostMapping(value = "/api/admin/insertUser")
    @ResponseBody
    public Result insertUser(@RequestBody User user)
    {
        if(userService.userIsInTable(user.getUsername())){
            return new Result(202);
        }else {
            userService.insertUser(user);
        }
        return new Result(200);
    }

    @PostMapping(value = "/api/admin/updateAdmin")
    @ResponseBody
    public void updataAdmin(@RequestBody Admin admin){
        System.out.println(admin);
        adminService.updateAdmin(admin);
    }

    @PostMapping(value = "/api/admin/updateUser")
    @ResponseBody
    public void updataAdmin(@RequestBody User user){
        System.out.println(user);
        userService.updateUser(user);
    }

    @GetMapping(value = "/api/admin/banAdmin")
    @ResponseBody
    public void banAdmin(@RequestParam("id") int id,@RequestParam("isUsed") Boolean isUsed){
        System.out.println(id+","+isUsed);
        adminService.banAdmin(id,isUsed);
    }

    @GetMapping(value = "/api/getUserByID")
    @ResponseBody
    public User getUserByID(@RequestParam("id") int id){
        return userService.getUserByID(id);
    }

    @PostMapping(value = "/api/updateUser")
    @ResponseBody
    public void updataAdmin2(@RequestBody User user){
        System.out.println(user);
        userService.updateUser(user);
    }
}
