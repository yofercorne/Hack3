package com.example.demo.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.infraestructure.CourseDetailsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CourseDetailsService {

    @Autowired
    private CourseDetailsRepository courseDetailsRepository;

    public List<CourseDetails> getAllCourseDetails() {
        return courseDetailsRepository.findAll();
    }

    public Optional<CourseDetails> getCourseDetailsById(Long id) {
        return courseDetailsRepository.findById(id);
    }

    public CourseDetails createCourseDetails(CourseDetails courseDetails) {
        return courseDetailsRepository.save(courseDetails);
    }

    public CourseDetails updateCourseDetails(Long id, CourseDetails courseDetails) {
        if (courseDetailsRepository.existsById(id)) {
            courseDetails.setId(id);
            return courseDetailsRepository.save(courseDetails);
        }
        return null;
    }

    public void deleteCourseDetails(Long id) {
        courseDetailsRepository.deleteById(id);
    }
}
