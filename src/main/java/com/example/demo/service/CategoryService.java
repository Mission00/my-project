package com.example.demo.service;

import com.example.demo.dao.CategoryDao;
import com.example.demo.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    public List<Category> getCategory(){
        return categoryDao.getCategory();
    }

}
