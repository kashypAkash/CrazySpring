package com.akash.lab2.controller;


import com.akash.lab2.model.Address;
import com.akash.lab2.model.Phone;
import com.akash.lab2.model.User;
import com.akash.lab2.service.UserService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class HelloController {

    @Autowired
    private  SessionFactory sessionFactory;

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String hello(ModelMap modelMap){


        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            //noinspection JpaQlInspection
            Query query = session.createQuery("from Phone where number = :number");

            query.setParameter("number","3124325");
            Phone phone = (Phone)query.getSingleResult();
            Set<Phone> phones = new HashSet<Phone>();
            phones.add(phone);



            /*User user1 = new User("bruce","wayne", "mr", new Address("101 S Fa","yghy","yg","89890"), phones);
            User user2 = new User("martha","wayne", "mrs", new Address("102 S Fafsd","yghsdafy","ygsdf","89089"), phones);*/
            User user3 = new User("thomas","wayne", "mrs", new Address("102 S Fafsd","yghsdafy","ygsdf","89089"), phones);


            session.save(user3);

            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return "home";
    }

/*    @PostMapping("/user")
    public String greetingSubmit(@ModelAttribute User user) {
        System.out.println("user-firstname:" +user.getFirstname());
        return "home";
    }*/

    @RequestMapping("/del")
    public String delete(){
/*        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();


            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return "home";*/
        return "home";
    }

    @RequestMapping("/users")
    public String users(Model modelMap){
        modelMap.addAttribute("users", userService.getUsers());
        return "home";

    }

}
