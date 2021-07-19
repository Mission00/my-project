package com.example.demo.service;

import com.example.demo.dao.AdminDao;
import com.example.demo.pojo.admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    AdminDao adminDao;
    public admin selectAdminByUserNameAndPassword(String username, String password)
    {
        admin admin = null;
        admin = adminDao.selectAdminByNameAndPassword(username,password);
        return admin;
    }
}
