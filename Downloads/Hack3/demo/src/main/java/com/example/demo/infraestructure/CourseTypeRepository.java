package com.example.demo.infraestructure;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.CourseType;

public interface CourseTypeRepository extends JpaRepository<CourseType, Long> {}