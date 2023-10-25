package com.example.demo.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.infraestructure.CourseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;



    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    public Optional<Course> findCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }


    public Optional<Course> getCourse(Long id) {
        return courseRepository.findById(id);
    }


}

