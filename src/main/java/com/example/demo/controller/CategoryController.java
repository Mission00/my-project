package com.example.demo.controller;

import com.example.demo.pojo.Category;
import com.example.demo.pojo.Language;
import com.example.demo.service.CategoryService;
import com.example.demo.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @CrossOrigin
    @GetMapping(value = "api/getcategory")
    @ResponseBody
    public List<Category> getCategory(){
        return categoryService.getCategory();
    }
}
