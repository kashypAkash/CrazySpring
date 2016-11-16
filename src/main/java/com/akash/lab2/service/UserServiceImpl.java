package com.akash.lab2.service;

import com.akash.lab2.dao.UserDao;
import com.akash.lab2.model.Phone;
import com.akash.lab2.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by akash on 11/13/16.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public List<Phone> getUsersByNumber(String numbers) {
        return userDao.getUsersByNumbers(numbers);
    }


}
