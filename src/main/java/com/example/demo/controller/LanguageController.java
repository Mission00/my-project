package com.example.demo.controller;

import com.example.demo.pojo.Language;
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
    @GetMapping(value = "api/getlanguage")
    @ResponseBody
    public List<Language> getLanguage(){
        return languageService.getLanguage();
    }

    @CrossOrigin
    @GetMapping(value = "api/deletelanguage")
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

    @CrossOrigin
    @GetMapping(value = "api/insertlanguage")
    @ResponseBody
    public void insertLanguage(@RequestParam("language") String language){
        try{
            languageService.insertLanguage(language);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @CrossOrigin
    @PostMapping(value = "api/updatelanguage")
    @ResponseBody
    public void updateLanguage(@RequestBody Language language){
        try{
            languageService.updateLanguage(language);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
