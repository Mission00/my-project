package com.example.demo.controller;

import com.example.demo.pojo.Permission;
import com.example.demo.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "api/admin/updatePermission")
    @ResponseBody
    public void updatePermission(@RequestBody Permission permission){
        System.out.println(permission);
        permissionService.updatePermission(permission);
    }

    @PostMapping(value = "api/admin/addPermission")
    @ResponseBody
    public void addPermission(@RequestBody Permission permission){
        System.out.println(permission);
        permissionService.addPermission(permission);
    }

    @PostMapping(value = "api/admin/deletePermission")
    @ResponseBody
    public void deletePermission(@RequestBody Permission permission){
        System.out.println(permission);
        permissionService.deletePermission(permission);
    }
}
