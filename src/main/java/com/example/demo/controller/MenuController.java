package com.example.demo.controller;

import com.example.demo.pojo.Menu;
import com.example.demo.result.Result;
import com.example.demo.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
public class MenuController {
    @Autowired
    private MenuService menuService;

    @CrossOrigin
    @GetMapping("/api/menu")
    @ResponseBody
    public Result menu() {
        List<Menu> menus = menuService.getMenusByCurrentUser();
        Result result = new Result(200);
        result.setData(menus);
        System.out.println(menus);
        return result;
    }
}
