package com.example.demo.infraestructure;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {}