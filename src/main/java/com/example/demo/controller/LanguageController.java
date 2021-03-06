package com.example.demo.controller;

import com.example.demo.pojo.Language;
import com.example.demo.pojo.Role;
import com.example.demo.result.Result;
import com.example.demo.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LanguageController {

    @Autowired
    LanguageService languageService;
    @CrossOrigin
    @GetMapping(value = "api/admin/getlanguage")
    @ResponseBody
    public List<Language> getLanguage(){
        return languageService.getLanguage();
    }

    @CrossOrigin
    @GetMapping(value = "api/admin/deletelanguage")
    @ResponseBody
    public Result deleteLanguage(@RequestParam("id") int id){
        Result result = new Result(200);
        try{
            if(languageService.isUsed(id)==0){
                languageService.deleteLanguage(id);
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

//    @PostMapping(value = "api/admin/insertlanguage")
//    @ResponseBody
//    public void insertLanguage(@RequestBody Language language){
//        System.out.println(1);
//        try{
//            languageService.insertLanguage(language.getLanguage());
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }

    @PostMapping(value = "api/admin/addLanguage")
    @ResponseBody
    public void addRole(@RequestBody Language language){
        System.out.println(language);
        languageService.insertLanguage(language.getLanguage());
    }

    @CrossOrigin
    @PostMapping(value = "api/admin/updatelanguage")
    @ResponseBody
    public void updateLanguage(@RequestBody Language language){
        try{
            languageService.updateLanguage(language);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
