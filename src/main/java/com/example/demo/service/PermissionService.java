package com.example.demo.service;

import com.example.demo.dao.PermissionDao;
import com.example.demo.dao.RolePermissionDao;
import com.example.demo.pojo.Permission;
import com.example.demo.pojo.Role;
import com.example.demo.pojo.RolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PermissionService {
    @Autowired
    private RoleService roleService;

    @Autowired
    private RolePermissionDao rolePermissionDao;
    @Autowired
    private PermissionDao permissionDao;

    public Set<String> listPermissionURLsByAdmin(String adminname) {
        List<Integer> rids = roleService.listRolesByAdmin(adminname)
                .stream().map(Role::getId).collect(Collectors.toList());

        List<Integer> pids = rolePermissionDao.findAllByRid(rids)
                .stream().map(RolePermission::getPid).collect(Collectors.toList());

        List<Permission> perms = permissionDao.findAllByIds(pids);

        Set<String> URLs = perms.stream().map(Permission::getUrl).collect(Collectors.toSet());

        return URLs;
    }

    public boolean needFilter(String requestAPI) {
        List<Permission> ps = permissionDao.findAll();
        for (Permission p: ps) {
            if (p.getUrl().equals(requestAPI)) {
                return true;
            }
        }
        return false;
    }

    public List<Permission> getAllPerms(){
        return permissionDao.findAll();
    }

    public void updatePermission(Permission permission){
        permissionDao.updatePermission(permission);
    }

    public void addPermission(Permission permission){
        permissionDao.addPermission(permission);
    }

    public void deletePermission(Permission permission) {
        permissionDao.deletePermission(permission);
    }
}
