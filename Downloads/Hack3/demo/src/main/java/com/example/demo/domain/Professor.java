package com.example.demo.domain;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Professor{
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)

    private Long id;
    private String name;
    private String lastname;
    private String email;
    private String fullname;

    public Professor (){

    };

    public Professor(Long id, String name, String lastname, String email ){
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
    };

    public String getEmail() {
        return email;
    }
    public Long getId() {
        return id;
    }
    public String getFullname() {
        return fullname;
    }
    public String getLastname() {
        return lastname;
    }
    public String getName() {
        return name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public void setName(String name) {
        this.name = name;
    }
    

}