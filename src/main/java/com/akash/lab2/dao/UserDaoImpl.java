package com.akash.lab2.dao;

import com.akash.lab2.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * Created by akash on 11/13/16.
 */

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getUsers() {
        //open a hibernate session
        Session session = sessionFactory.openSession();

        // Get all the users
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        criteriaQuery.from(User.class);
        List<User> users = session.createQuery(criteriaQuery).getResultList();

        //Close the session
        session.close();
        return users;
    }

    @Override
    public User getUserById(int id) {

   /*     //Open the session
        Session session = sessionFactory.openSession();

        // Get the User by Id
        User user = session.get(User.class,id);
        Hibernate.initialize(user.get());
        session.close();
        return user;*/

        return null;
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }
}
