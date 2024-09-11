package com.example.demo.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.infraestructure.CourseTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CourseTypeService {

    @Autowired
    private CourseTypeRepository coursetypeRepository;



    public CourseType saveCourseType(CourseType coursetype) {
        return coursetypeRepository.save(coursetype);
    }

    public Optional<CourseType> findCourseTypeById(Long id) {
        return coursetypeRepository.findById(id);
    }

    public List<CourseType> findAllCourseTypes() {
        return coursetypeRepository.findAll();
    }


    public Optional<CourseType> getCourseType(Long id) {
        return coursetypeRepository.findById(id);
    }


}

