package com.example.demo.service;

import com.example.demo.dao.RoleMenuDao;
import com.example.demo.pojo.Menu;
import com.example.demo.pojo.RoleMenu;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class RoleMenuService {
    @Autowired
    private RoleMenuDao roleMenuDao;

    public List<RoleMenu> findAllByRid(int rid) {
        return roleMenuDao.findAllByRid(rid);
    }
    public List<RoleMenu> findAllByRids(List<Integer> rids) {
        System.out.println("rids:" + rids);
        return roleMenuDao.findAllByRids(rids);
    }

    @Transactional
    public void saveRoleMenu(int rid, LinkedHashMap menusIds){
        roleMenuDao.deleteAllByRid(rid);
        List<RoleMenu> rms = new ArrayList<>();
        for (Integer mid : (List<Integer>)menusIds.get("menusIds")) {
            RoleMenu rm = new RoleMenu();
            rm.setMid(mid);
            rm.setRid(rid);
            rms.add(rm);
        }
        roleMenuDao.insertRoleMenuByRms(rms);
    }

}
