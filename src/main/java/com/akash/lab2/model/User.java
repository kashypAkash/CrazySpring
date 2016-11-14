package com.akash.lab2.model;

import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String firstname;
    private String lastname;
    private String title;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="address_id")
    private Address address;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="user_phone", joinColumns=@JoinColumn(name="user_id"), inverseJoinColumns=@JoinColumn(name="phone_id"))
    private Set<Phone> phones;

    public User(){}

    public User(String firstname, String lastname, String title, Address address, Set<Phone> phones) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.title = title;
        this.address = address;
        this.phones = phones;
    }


    public int getId() {
        return userId;
    }

    public void setId(int userId) {
        this.userId = userId;
    }


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Phone> getPhones() {
        return phones;
    }

    public void setPhones(Set<Phone> phones) {
        this.phones = phones;
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
