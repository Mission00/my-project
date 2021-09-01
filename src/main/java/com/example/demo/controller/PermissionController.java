package com.example.demo.controller;

import com.example.demo.pojo.Permission;
import com.example.demo.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class PermissionController {
    @Autowired
    private PermissionService permissionService;
    @GetMapping(value = "api/admin/getPermission")
    @ResponseBody
    public List<Permission> getPermission(){
        return permissionService.getAllPerms();
    }
}
