package com.example.demo.service;

import com.example.demo.dao.RolePermissionDao;
import com.example.demo.pojo.Permission;
import com.example.demo.pojo.RolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class RolePermissionService {
    @Autowired
    RolePermissionDao rolePermissionDao;

    @Transactional
    public void saveRolePermission(int rid,List<Permission> permissions){
        rolePermissionDao.deleteRolePermissionByRid(rid);
        List<RolePermission> rps = new ArrayList<>();
        for(Permission p : permissions){
            RolePermission rp = new RolePermission();
            rp.setRid(rid);
            rp.setPid(p.getId());
            rps.add(rp);
        }
        rolePermissionDao.insertRolePermissionByRps(rps);
    }

    public void deleteByRid(int rid){
        rolePermissionDao.deleteRolePermissionByRid(rid);
    }
}
