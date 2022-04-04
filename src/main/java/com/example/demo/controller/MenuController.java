package com.example.demo.controller;

import com.example.demo.pojo.Menu;
import com.example.demo.result.Result;
import com.example.demo.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
@CrossOrigin
public class MenuController {
    @Autowired
    private MenuService menuService;


    @GetMapping("/api/admin/menu")
    @ResponseBody
    public Result menu() {
        List<Menu> menus = menuService.getMenusByCurrentUser();
        Result result = new Result(200);
        result.setData(menus);
        System.out.println(menus);
        return result;
    }

    @GetMapping(value = "/api/admin/role/getAllMenu")
    @ResponseBody
    public List<Menu> menus(@RequestParam("rid") int rid){
        List<Menu> menulist = menuService.getMenusByRid(rid);
        System.out.println(menulist);
        return menulist;
    }

    @GetMapping(value = "/api/admin/role/allMenu")
    @ResponseBody
    public List<Menu> getAllMenu(){
        List<Menu> menulist = menuService.getAllMenu();
        return menulist;
    }

}
