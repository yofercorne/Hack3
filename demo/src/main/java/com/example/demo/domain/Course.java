package com.example.demo.domain;
import jakarta.persistence.*;

import java.util.Set;
import java.util.HashSet;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)

    private Long id;
    private Integer credits;
    private String name;
    private String code;
    private String HRgroup;
    private Integer cicle;
    private String VRgroup;
    
    @OneToMany(fetch = FetchType.LAZY)
    private Set<CourseType> coursetype = new HashSet<>();

    public Course(){}
    public Course(Long id, String name, String code, String HRgroup,Integer credits, Integer cicle, String VRgroup, Set<CourseType> coursetype){
        this.HRgroup = HRgroup;
        this.VRgroup = VRgroup;
        this.cicle = cicle;  
        this.code = code;
        this.coursetype = coursetype;
        this.credits = credits;
        this.id = id;
        this.name = name;
    }

    public Integer getCicle() {
        return cicle;
    }
    public String getCode() {
        return code;
    }
    public Set<CourseType> getCoursetype() {
        return coursetype;
    }
    public Integer getCredits() {
        return credits;
    }
    public String getHRgroup() {
        return HRgroup;
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getVRgroup() {
        return VRgroup;
    }
    public void setCicle(Integer cicle) {
        this.cicle = cicle;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public void setCoursetype(Set<CourseType> coursetype) {
        this.coursetype = coursetype;
    }
    public void setCredits(Integer credits) {
        this.credits = credits;
    }
    public void setHRgroup(String hRgroup) {
        HRgroup = hRgroup;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setVRgroup(String vRgroup) {
        VRgroup = vRgroup;
    }
}
