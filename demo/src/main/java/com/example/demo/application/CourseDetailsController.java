package com.example.demo.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.CourseDetails;
import com.example.demo.domain.CourseDetailsService;


@RestController
@RequestMapping("/courseDetailss")
public class CourseDetailsController {

    @Autowired
    private CourseDetailsService courseDetailsService;

    @PostMapping
    public ResponseEntity<CourseDetails> createCourseDetails(@RequestBody CourseDetails courseDetails) {
        return new ResponseEntity<>(courseDetailsService.createCourseDetails(courseDetails), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDetails> courseDetails(@PathVariable Long id) {
        Optional<CourseDetails> courseDetails = courseDetailsService.getCourseDetailsById(id);
        return new ResponseEntity<>(courseDetails.get(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CourseDetails>> getAllCourseDetailss() {
        return new ResponseEntity<>(courseDetailsService.getAllCourseDetails(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDetails> updateCourseDetails(@PathVariable Long id, @RequestBody CourseDetails courseDetails) {
        CourseDetails updatedCourseDetails = courseDetailsService.updateCourseDetails(id, courseDetails);
        if (updatedCourseDetails != null) {
            return new ResponseEntity<>(updatedCourseDetails, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourseDetails(@PathVariable Long id) {
        courseDetailsService.deleteCourseDetails(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}