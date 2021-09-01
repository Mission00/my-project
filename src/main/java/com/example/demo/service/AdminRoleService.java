package com.example.demo.service;

import com.example.demo.dao.AdminRoleDao;
import com.example.demo.pojo.AdminRole;
import com.example.demo.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminRoleService {
    @Autowired
    private AdminRoleDao adminRoleDao;

    public List<AdminRole> listAllByAid(int aid) {
        return adminRoleDao.findAllByAid(aid);
    }
    @Transactional
    public void saveRoleChange(int aid,List<Role> roles){
        adminRoleDao.deleteAllByAid(aid);

        List<AdminRole> ars = new ArrayList<>();
        roles.forEach(r->{
            AdminRole ar = new AdminRole();
            ar.setAid(aid);
            ar.setRid(r.getId());
            ars.add(ar);
        });
        System.out.println(ars);
        adminRoleDao.saveAll(ars);
    }
}
