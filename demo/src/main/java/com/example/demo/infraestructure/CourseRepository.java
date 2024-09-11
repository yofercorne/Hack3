package com.example.demo.infraestructure;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {}