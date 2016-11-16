package com.akash.lab2.dao;

import com.akash.lab2.model.Phone;
import com.akash.lab2.model.User;

import java.util.List;

/**
 * Created by akash on 11/13/16.
 */
public interface UserDao {
    List<User> getUsers();
    User getUserById(int id);
    List<Phone> getUsersByNumbers(String numbers);
    void saveUser(User user);
    void deleteUser(User user);
}
