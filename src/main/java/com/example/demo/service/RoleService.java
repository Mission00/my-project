package com.example.demo.service;

import com.example.demo.dao.RoleDao;
import com.example.demo.dao.RolePermissionDao;
import com.example.demo.pojo.AdminRole;
import com.example.demo.pojo.Permission;
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

    @Autowired
    private RolePermissionService rolePermissionService;

    public Role findById(int id) {
        return roleDao.findById(id);
    }

    public List<Role> listRolesByAdmin(String adminName) {
        int aid = adminService.getAdminByName(adminName).getId();
        List<Integer> rids = adminRoleService.listAllByAid(aid)
                .stream().map(AdminRole::getRid).collect(Collectors.toList());
        System.out.println("rid:");
        System.out.println(rids);
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

    public void updateRole(Role role){
        roleDao.updateRole(role);
        rolePermissionService.saveRolePermission(role.getId(),role.getPerms());
    }

    public void addRole(Role role){
        roleDao.addRole(role);
    }

    public void deleteRole(Role role){
        roleDao.deleteRole(role);
    }
}
