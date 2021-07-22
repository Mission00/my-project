package com.example.demo.service;

import com.example.demo.dao.AdminDao;
import com.example.demo.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    AdminDao adminDao;
    public Admin selectAdminByAdminNameAndPassword(String adminname, String password)
    {
        Admin admin = null;
        admin = adminDao.selectAdminByNameAndPassword(adminname,password);
        return admin;
    }

    public List<Admin> selectAdmin(int pageSize,int currentPage)
    {
        List<Admin> adminList = null;
        adminList = adminDao.selectAdmin(pageSize,(currentPage-1)*pageSize);
        return adminList;
    }

    public int getAdminTotol()
    {
        return adminDao.getAdminTotol();
    }

    public void deleteAdmin(int id){
        adminDao.deleteAdmin(id);
    }
}
