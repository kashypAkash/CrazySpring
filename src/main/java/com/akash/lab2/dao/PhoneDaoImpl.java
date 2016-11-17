package com.akash.lab2.dao;

import com.akash.lab2.model.Phone;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by akash on 11/16/16.
 */

@Repository
public class PhoneDaoImpl implements PhoneDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createPhone(Phone phone) {
        // Open a session
        Session session = sessionFactory.openSession();

        // begin a transaction
        session.beginTransaction();

        // save the user & commit trasaction
        session.save(phone);
        session.getTransaction().commit();

        //close the session
        session.close();
    }

    @Override
    public void updatePhone(Phone phone) {

    }

    @Override
    public void deletePhone(Phone phone) {

    }
}
