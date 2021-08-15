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

    public void deleteLanguage(int id){
        languageDao.deleteLanguage(id);
    }

    public void updateLanguage(Language language){
        languageDao.updateLanguage(language);
    }

    public void insertLanguage(String language){
        languageDao.insertLanguage(language);
    }

    public int isUsed(int id){
        return languageDao.isUsed(id);
    }
}
