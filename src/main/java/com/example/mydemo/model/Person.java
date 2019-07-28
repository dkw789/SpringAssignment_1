package com.example.mydemo.model;

import javax.persistence.*;

@Entity
@Table(name = "Person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private String address;

    private String telephone;

    private String email;

    private String role;

    public Person() {

    }

    public Person(long id, String firstName, String lastName, String address, String telephone, String email, String role) {
    this.id=id;
    this.firstName=firstName;
    this.lastName=lastName;
    this.address=address;
    this.telephone=telephone;
    this.email=email;
    this.role=role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public  String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

//    @Override
//    public Person findOne(int id) {
//        return dao.findById(id);
//    }
    // setters and getters
}
