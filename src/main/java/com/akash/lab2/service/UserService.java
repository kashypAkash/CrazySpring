package com.akash.lab2.service;

import com.akash.lab2.model.Phone;
import com.akash.lab2.model.User;

import java.util.List;

/**
 * Created by akash on 11/13/16.
 */
public interface UserService {
    List<User> getUsers();
    User getUserById(int id);
    void saveUser(User user);
    void deleteUser(User user);
    void updateUser(User user);
    List<Phone> getUsersByNumber(String numbers);
}
