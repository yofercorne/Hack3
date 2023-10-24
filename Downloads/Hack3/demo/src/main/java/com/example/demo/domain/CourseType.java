package com.example.demo.domain;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class CourseType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;

    public CourseType(){}
    public CourseType(Long id, String name){this.id = id; this.name = name;}
    public Long getId() {
        return id;
    }public String getName() {
        return name;
    }public void setId(Long id) {
        this.id = id;
    }public void setName(String name) {
        this.name = name;
    }
}
