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

import com.example.demo.domain.CourseAssessment;
import com.example.demo.domain.CourseAssessmentService;
//import com.example.demo.domain.GenericEntityService;

@RestController
@RequestMapping("/courseAssessments")
public class CourseAssessmentController {

    @Autowired
    private CourseAssessmentService courseAssessmentService;  

    @PostMapping
    public ResponseEntity<CourseAssessment> createCourseAssessment(@RequestBody CourseAssessment courseAssessment) {
        return new ResponseEntity<>(courseAssessmentService.saveCourseAssessment(courseAssessment), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CourseAssessment>> getAllCourseAssessments() {
        return new ResponseEntity<>(courseAssessmentService.findAllCourseAssessments(), HttpStatus.OK);
    }
}
