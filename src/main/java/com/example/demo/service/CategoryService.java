package com.example.demo.service;

import com.example.demo.dao.CategoryDao;
import com.example.demo.pojo.Category;
import com.example.demo.pojo.Language;
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

    public void deleteCategory(int id){
        categoryDao.deleteCategory(id);
    }

    public void updateCategory(Category category){
        categoryDao.updateCategory(category);
    }

    public void insertCategory(String category){
        categoryDao.insertCategory(category);
    }

    public int isUsed(int id){
        return categoryDao.isUsed(id);
    }

}
