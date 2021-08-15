package com.example.demo.service;

import com.example.demo.dao.AdminDao;
import com.example.demo.pojo.Admin;
import org.apache.ibatis.annotations.Param;
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

    public List<Admin> selectAdmin(int pageSize,int currentPage,String searchMsg)
    {
        List<Admin> adminList = null;
        adminList = adminDao.selectAdmin(pageSize,(currentPage-1)*pageSize,searchMsg);
        return adminList;
    }


    public void deleteAdmin(int id){
        adminDao.deleteAdmin(id);
    }

    public Boolean adminIsInTable(String adminName){
        return adminDao.selectAdminByName(adminName) != null;
    }

    public void insertAdmin(Admin admin){
        adminDao.insertAdmin(admin);
    }

    public int getTotal(String searchMsg){
        return adminDao.getTotal(searchMsg);
    }

    public void updateAdmin(Admin admin){
        adminDao.updateAdmin(admin);
    }

    public void banAdmin(int id,boolean isUsed){adminDao.banAdmin(id,isUsed);}

}
