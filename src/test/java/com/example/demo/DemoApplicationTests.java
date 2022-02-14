package com.example.demo;

import com.example.demo.controller.RoleController;
import com.example.demo.dao.PermissionDao;
import com.example.demo.pojo.Role;
import com.example.demo.service.MenuService;
import com.example.demo.service.RoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private MenuService menuService;
    @Autowired
    private RoleController roleController;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Test
    void contextLoads() {
        ValueOperations<String, String> opsForValue = this.stringRedisTemplate.opsForValue();
        opsForValue.set("name", "lisi"); // 缓存数据
        String value = opsForValue.get("name"); // 获取缓存数据
        System.out.println(value);
    }


}
