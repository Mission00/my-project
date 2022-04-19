package com.example.demo.service;


import com.example.demo.dao.UserDao;
import com.example.demo.pojo.Admin;
import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public boolean insertUser(User user)
    {
        if(userDAO.selectUserByName(user.getUsername())==null)
        {
            userDAO.insertUser(user);
            return true;
        }
        return false;
    }

    public List<User> selectUser(int pageSize, int currentPage, String searchMsg)
    {
        List<User> userList = null;
        userList = userDAO.selectUser(pageSize,(currentPage-1)*pageSize,searchMsg);
        return userList;
    }

    public int getTotal(String searchMsg){
        return userDAO.getTotal(searchMsg);
    }

    public void deleteUser(int id){
        userDAO.deleteUser(id);
    }

    public Boolean userIsInTable(String userName){
        return userDAO.selectUserByName(userName) != null;
    }

    public void updateUser(User user){
        userDAO.updateUser(user);
    }

    public User getUserByID(int id){
        return userDAO.getUserByID(id);
    }

}
