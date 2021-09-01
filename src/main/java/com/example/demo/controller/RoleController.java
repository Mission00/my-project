package com.example.demo.controller;

import com.example.demo.pojo.Menu;
import com.example.demo.pojo.Role;
import com.example.demo.service.MenuService;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@CrossOrigin
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;

    @GetMapping(value = "api/admin/getAllRole")
    @ResponseBody
    public List<Role> getAllRole(){
        List<Role> roles = new ArrayList<>();
        roles = roleService.finAll();
        for(Role role:roles){
            List<Menu> menus = menuService.getMenusByRid(role.getId());
            role.setMenus(menus);
        }
        return roles;
    }

    @GetMapping(value = "api/admin/deleteRole")
    @ResponseBody
    public void deleteRole(@RequestParam("id") int id){

    }
}
