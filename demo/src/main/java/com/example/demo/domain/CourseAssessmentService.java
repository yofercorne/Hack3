package com.example.demo.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.infraestructure.CourseAssessmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CourseAssessmentService {

    @Autowired
    private CourseAssessmentRepository courseassessmentRepository;



    public CourseAssessment saveCourseAssessment(CourseAssessment courseassessment) {
        return courseassessmentRepository.save(courseassessment);
    }

    public Optional<CourseAssessment> findCourseAssessmentById(Long id) {
        return courseassessmentRepository.findById(id);
    }

    public List<CourseAssessment> findAllCourseAssessments() {
        return courseassessmentRepository.findAll();
    }


    public Optional<CourseAssessment> getCourseAssessment(Long id) {
        return courseassessmentRepository.findById(id);
    }


}

