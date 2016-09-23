package com.schoolofnet.contacts;

/**
 * Created by Leonan-Mac on 9/23/16.
 */
public class Person {

    private Integer id;
    private String name;
    private String lastname;
    private String email;
    private String companyName;
    private String telephone;


    public Person() {

    }

    public Person(Integer id, String name, String lastname, String email, String companyName, String telephone) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.companyName = companyName;
        this.telephone = telephone;

    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
