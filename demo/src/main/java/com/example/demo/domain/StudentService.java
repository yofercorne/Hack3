package com.example.demo.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.infraestructure.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;



    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Optional<Student> findStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }


    public Optional<Student> getStudent(Long id) {
        return studentRepository.findById(id);
    }


}

