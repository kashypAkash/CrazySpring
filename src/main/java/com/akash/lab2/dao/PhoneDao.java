package com.akash.lab2.dao;

import com.akash.lab2.model.Phone;

/**
 * Created by akash on 11/13/16.
 */
public interface PhoneDao {
    void createPhone(Phone phone);
    void updatePhone(Phone phone);
    void deletePhone(Phone phone);
    Phone getPhoneById(int id);
}
