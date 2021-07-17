package com.example.demo.service;


import com.example.demo.dao.UserDao;
import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserService {

    @Autowired
    private UserDao userDAO;

    public User selectUserByUserNameAndPassword(String username, String password)
    {
        User user = null;
        user=userDAO.selectUserByNameAndPassword(username,password);
        return user;
    }

    public boolean insertUser(String username, String password)
    {
        if(userDAO.selectUserByName(username)==null)
        {
            userDAO.insertUser(username,password);
            return true;
        }
        return false;
    }


}
