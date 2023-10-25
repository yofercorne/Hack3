package com.example.demo.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Periodo> periodo  = new HashSet<>();
    //private Periodo periodo;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Course> course= new HashSet<>();
    //private Course course;

    public CourseAssessment(){}
    public CourseAssessment(Long id,String title, String tipoNota, String numNota, String nomenclatura, Set<Periodo> periodo, Set<Course> course){
        this.tipoNota = tipoNota;
        this.id = id;
        this.numNota = numNota;
        this.nomenclatura = nomenclatura;
        this.periodo = periodo;
        this.title = title;
        this.course = course;
    }


    public Set<Course> getCourse() {
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
    public Set<Periodo> getPeriodo() {
        return periodo;
    }
    public String getTipoNota() {
        return tipoNota;
    }
    public String getTitle() {
        return title;
    }
    public void setCourse(Set<Course> course) {
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
    public void setPeriodo(Set<Periodo> periodo) {
        this.periodo = periodo;
    }
    public void setTipoNota(String tipoNota) {
        this.tipoNota = tipoNota;
    }
    public void setTitle(String title) {
        this.title = title;
    }



}
