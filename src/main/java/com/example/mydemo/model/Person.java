package com.example.mydemo.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

//@Getter
//@Setter
@Data
@Builder
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

    private String job;

    public Person() {

    }

    public Person(long id, String firstName, String lastName, String address, String telephone, String email, String job) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
        this.job = job;
    }


}
