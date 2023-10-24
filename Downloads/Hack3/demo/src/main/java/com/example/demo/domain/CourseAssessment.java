package com.example.demo.domain;

import jakarta.persistence.*;

import java.time.Period;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class CourseAssessment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String title;
    private String tipoNota;
    private String numNota;
    private String nomenclatura;

     @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "period_id") 
    private Period period;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id") 
    private Course course;

    public CourseAssessment(){}
    public CourseAssessment(Long id,String title, String tipoNota, String numNota, String nomenclatura, Period period, Course course){
        this.tipoNota = tipoNota;
        this.id = id;
        this.numNota = numNota;
        this.nomenclatura = nomenclatura;
        this.period = period;
        this.title = title;
        this.course = course;
    }


    public Course getCourse() {
        return course;
    }
    public Long getId() {
        return id;
    }
    public String getNomenclatura() {
        return nomenclatura;
    }
    public String getNumNota() {
        return numNota;
    }
    public Period getPeriod() {
        return period;
    }
    public String getTipoNota() {
        return tipoNota;
    }
    public String getTitle() {
        return title;
    }
    public void setCourse(Course course) {
        this.course = course;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setNomenclatura(String nomenclatura) {
        this.nomenclatura = nomenclatura;
    }
    public void setNumNota(String numNota) {
        this.numNota = numNota;
    }
    public void setPeriod(Period period) {
        this.period = period;
    }
    public void setTipoNota(String tipoNota) {
        this.tipoNota = tipoNota;
    }
    public void setTitle(String title) {
        this.title = title;
    }



}
