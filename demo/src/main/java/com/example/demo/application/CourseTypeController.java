package com.example.demo.application;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.CourseType;
import com.example.demo.domain.CourseTypeService;
//import com.example.demo.domain.GenericEntityService;

@RestController
@RequestMapping("/courseType")
public class CourseTypeController {

    @Autowired
    private CourseTypeService courseTypeService;  

    @PostMapping
    public ResponseEntity<CourseType> createCourse(@RequestBody CourseType courseType) {
        return new ResponseEntity<>(courseTypeService.saveCourseType(courseType), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CourseType>> getAllCourses() {
        return new ResponseEntity<>(courseTypeService.findAllCourseTypes(), HttpStatus.OK);
    }
}
