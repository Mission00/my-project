package com.example.demo.controller;

import com.example.demo.pojo.Menu;
import com.example.demo.pojo.Role;
import com.example.demo.pojo.RoleMenu;
import com.example.demo.service.MenuService;
import com.example.demo.service.RoleMenuService;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Controller
@CrossOrigin
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private RoleMenuService roleMenuService;

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

    @PostMapping(value = "api/admin/role/updateRole")
    @ResponseBody
    public void updateRole(@RequestBody Role role){
        roleService.updateRole(role);
    }

    @PutMapping(value = "api/admin/role/updateMenu")
    @ResponseBody
    public void updateRoleMenu(@RequestParam int rid, @RequestBody LinkedHashMap menusIds){
        System.out.println(rid);
        System.out.println(menusIds);

        roleMenuService.saveRoleMenu(rid,menusIds);
    }

    @PostMapping(value = "api/admin/role/addRole")
    @ResponseBody
    public void addRole(@RequestBody Role role){
        System.out.println(role);
        roleService.addRole(role);
    }

    @PostMapping(value = "api/admin/role/deleteRole")
    @ResponseBody
    public void deleteRole(@RequestBody Role role){
        roleService.deleteRole(role);
    }
}
