package com.example.demo.application;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.CourseAssessment;
import com.example.demo.domain.CourseDetails;
import com.example.demo.domain.CourseDetailsService;
import com.example.demo.domain.Professor;
import com.example.demo.domain.Student;


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
    CourseDetails existingCourseDetails = courseDetailsService.getCourseDetailsById(id).orElse(null);
    
    if (existingCourseDetails != null) {

        existingCourseDetails.setScore(courseDetails.getScore());
        existingCourseDetails.setSection(courseDetails.getSection());
        existingCourseDetails.setSectionGroup(courseDetails.getSectionGroup());

        existingCourseDetails.setStudent(courseDetails.getStudent());

        existingCourseDetails.setProfessor(courseDetails.getProfessor());

        existingCourseDetails.setCourseAssessments(courseDetails.getCourseAssessments());
        
        CourseDetails updatedCourseDetails = courseDetailsService.updateCourseDetails(id, existingCourseDetails);
        if (updatedCourseDetails != null) {
            return new ResponseEntity<>(updatedCourseDetails, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}


    @DeleteMapping("/{id}")
public ResponseEntity<Void> deleteCourseAssessmentDetails(@PathVariable Long id) {
    CourseDetails existingCourseDetails = courseDetailsService.getCourseDetailsById(id).orElse(null);
    
    if (existingCourseDetails != null) {
        // Antes de eliminar, desvincula las relaciones con Student, Professor y CourseAssessment
        Set<Student> student = existingCourseDetails.getStudent();
        Set<Professor> professor = existingCourseDetails.getProfessor();
        Set<CourseAssessment> courseAssessments = existingCourseDetails.getCourseAssessments();

        existingCourseDetails.setStudent(null);
        existingCourseDetails.setProfessor(null);
        existingCourseDetails.setCourseAssessments(new HashSet<>()); 

        courseDetailsService.deleteCourseDetails(id);

        existingCourseDetails.setStudent(student);
        existingCourseDetails.setProfessor(professor);
        existingCourseDetails.setCourseAssessments(courseAssessments);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

    
}