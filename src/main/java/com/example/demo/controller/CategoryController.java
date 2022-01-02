package com.example.demo.controller;

import com.example.demo.pojo.Category;
import com.example.demo.result.Result;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @CrossOrigin
    @GetMapping(value = "api/admin/getcategory")
    @ResponseBody
    public List<Category> getCategory(){
        return categoryService.getCategory();
    }


    @CrossOrigin
    @GetMapping(value = "api/admin/deletecategory")
    @ResponseBody
    public Result deleteCategory(@RequestParam("id") int id){
        Result result = new Result(200);
        try{
            if(categoryService.isUsed(id)==0){
                categoryService.deleteCategory(id);
            }else{
                result.setCode(400);
                result.setData("无法删除，使用中");
            }
        }catch (Exception e){
            result.setCode(400);
            result.setData(e.getMessage());
        }
        return result;
    }

}
