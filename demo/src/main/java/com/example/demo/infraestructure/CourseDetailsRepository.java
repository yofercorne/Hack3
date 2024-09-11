package com.example.demo.infraestructure;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.CourseDetails;

public interface CourseDetailsRepository extends JpaRepository<CourseDetails, Long> {}