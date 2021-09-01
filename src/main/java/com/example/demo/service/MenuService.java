package com.example.demo.service;

import com.example.demo.dao.MenuDao;
import com.example.demo.pojo.Admin;
import com.example.demo.pojo.AdminRole;
import com.example.demo.pojo.Menu;
import com.example.demo.pojo.RoleMenu;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuService {
    @Autowired
    private MenuDao menuDao;
    @Autowired
    private AdminService adminService;
    @Autowired
    private AdminRoleService adminRoleService;
    @Autowired
    private RoleMenuService roleMenuService;

    public List<Menu> getAllByParentId(int parentId) {
        return menuDao.findAllByParentId(parentId);
    }

    public List<Menu> getMenusByCurrentUser() {
        // Get current user in DB.
        String adminName = SecurityUtils.getSubject().getPrincipal().toString();
        Admin admin = adminService.getAdminByName(adminName);

        System.out.println(admin.getId());
        // Get roles' ids of current user.
        List<Integer> rids = adminRoleService.listAllByAid(admin.getId())
                .stream().map(AdminRole::getRid).collect(Collectors.toList());
        System.out.println(rids);

        // Get menu items of these roles.
        List<Integer> menuIds = roleMenuService.findAllByRids(rids)
                .stream().map(RoleMenu::getMid).collect(Collectors.toList());
        System.out.println(menuIds);
        List<Menu> menus = menuDao.findAllByIds(menuIds).stream().distinct().collect(Collectors.toList());
        System.out.println(menus);
        // Adjust the structure of the menu.
        handleMenus(menus);
        return menus;
    }

    public List<Menu> getMenusByRid(int rid){
        List<Menu> menus = menuDao.getMenusByRid(rid);
        handleMenus(menus);
        return menus;
    }

    public void handleMenus(List<Menu> menus) {
        for (Menu menu : menus) {
            List<Menu> children = getAllByParentId(menu.getId());
            menu.setChildren(children);
        }

        Iterator<Menu> iterator = menus.iterator();
        while (iterator.hasNext()) {
            Menu menu = iterator.next();
            if (menu.getParentId() != 0) {
                iterator.remove();
            }
        }
    }

    public List<Menu> getAllMenu(){
        List<Menu> menuList = menuDao.getAllMenu();
        handleMenus(menuList);
        return menuList;
    }
}
