package com.example.demo.service;

import com.example.demo.dao.AdminRoleDao;
import com.example.demo.pojo.AdminRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminRoleService {
    @Autowired
    private AdminRoleDao adminRoleDao;

    public List<AdminRole> listAllByAid(int aid) {
        return adminRoleDao.findAllByAid(aid);
    }
}
