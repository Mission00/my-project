package com.example.demo.service;

import com.example.demo.dao.CategoryDao;
import com.example.demo.dao.LanguageDao;
import com.example.demo.pojo.Category;
import com.example.demo.pojo.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LanguageService {
    @Autowired
    private LanguageDao languageDao;

    public List<Language> getLanguage(){
        return languageDao.getLanguage();
    }

}
