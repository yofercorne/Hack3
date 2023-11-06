package com.example.demo.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.infraestructure.EnrolRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EnrolService {

    @Autowired
    private EnrolRepository enrolRepository;

    public Enrol saveEnrol(Enrol enrol) {
        return enrolRepository.save(enrol);
    }

    public Optional<Enrol> findEnrolById(Long id) {
        return enrolRepository.findById(id);
    }

    public List<Enrol> findAllEnrols() {
        return enrolRepository.findAll();
    }

    // Add more methods as needed
}
