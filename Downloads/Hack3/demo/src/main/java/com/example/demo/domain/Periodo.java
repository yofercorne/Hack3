package com.example.demo.domain;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")


public class Periodo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String code;

    public Periodo(){
    }

    public Periodo(Long id, String name, String code){
        this.code = code;
        this.id = id;
        this.name = name;
    }

    public String getCode() {
        return code;
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
}
