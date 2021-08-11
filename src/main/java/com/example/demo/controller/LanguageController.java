package com.example.demo.controller;

import com.example.demo.pojo.Language;
import com.example.demo.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
