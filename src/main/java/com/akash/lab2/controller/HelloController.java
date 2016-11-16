package com.akash.lab2.controller;


import com.akash.lab2.model.Address;
import com.akash.lab2.model.Phone;
import com.akash.lab2.model.User;
import com.akash.lab2.service.UserService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HelloController {

    @Autowired
    private  SessionFactory sessionFactory;

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String hello(){
        return "home";
    }

    @PostMapping("/add")
    public String check(@RequestParam(value = "firstname") String firstname,
                      @RequestParam(value = "lastname") String lastname,
                      @RequestParam(value = "title") String title,
                      @RequestParam(value = "street") String street,
                      @RequestParam(value = "city") String city,
                      @RequestParam(value = "state") String state,
                      @RequestParam(value = "zip") String zip,
                      @RequestParam(value = "phones") String phones
                      ){

        List<Phone> phoneList = userService.getUsersByNumber(phones);
        if(phoneList!=null){
            User user = new User(firstname,lastname,title,new Address(street,city,state,zip),phoneList);
            userService.saveUser(user);
            return "redirect:/users";
        }
            return "badrequest";

    }

/*        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            //noinspection JpaQlInspection
            Query query = session.createQuery("from Phone where number = :number");

            query.setParameter("number","3124325");
            Phone phone = (Phone)query.getSingleResult();
            Set<Phone> phones = new HashSet<Phone>();
            phones.add(phone);



            User user1 = new User("bruce","wayne", "mr", new Address("101 S Fa","yghy","yg","89890"), phones);
            User user2 = new User("martha","wayne", "mrs", new Address("102 S Fafsd","yghsdafy","ygsdf","89089"), phones);
            User user3 = new User("thomas","wayne", "mrs", new Address("102 S Fafsd","yghsdafy","ygsdf","89089"), phones);


            session.save(user3);

            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
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
