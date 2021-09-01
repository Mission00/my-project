package com.example.demo.service;

import com.example.demo.dao.RoleDao;
import com.example.demo.pojo.AdminRole;
import com.example.demo.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminRoleService adminRoleService;

    public Role findById(int id) {
        return roleDao.findById(id);
    }

    public List<Role> listRolesByAdmin(String adminName) {
        int aid = adminService.getAdminByName(adminName).getId();
        List<Integer> rids = adminRoleService.listAllByAid(aid)
                .stream().map(AdminRole::getRid).collect(Collectors.toList());
        return roleDao.findAllByRid(rids);
    }

    public List<Role> finAll(){
        try{
            List<Role> roles= roleDao.findAll();
            return roles;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
