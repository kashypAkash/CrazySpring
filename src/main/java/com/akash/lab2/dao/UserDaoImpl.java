package com.akash.lab2.dao;

import com.akash.lab2.model.Phone;
import com.akash.lab2.model.User;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
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
    public List<Phone> getUsersByNumbers(String numbers) {

        Session session = sessionFactory.openSession();
        List<Phone> phoneList = new ArrayList<>();
            String[] list = numbers.split(";");
            for(String number: list){
                //noinspection JpaQlInspection
                Query query = session.createQuery("from Phone where number = :number");
                query.setParameter("number",number);
                try {
                    Phone phone = (Phone) query.getSingleResult();
                    phoneList.add(phone);
                }
                catch (NoResultException e){
                    session.close();
                    return null;
                }
            }
            session.close();
            return phoneList;
    }


    @Override
    public void saveUser(User user) {
        // todo: implement transactions
        // Open a session
        Session session = sessionFactory.openSession();

        // begin a transaction
        session.beginTransaction();

        // save the user & commit trasaction
        session.save(user);
        session.getTransaction().commit();

        //close the session
        session.close();

    }

    @Override
    public void deleteUser(User user) {

    }
}
