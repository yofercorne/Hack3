package com.example.demo.application;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Enrol;
import com.example.demo.domain.EnrolService;

@RestController
@RequestMapping("/enrols")
public class EnrolController {

    @Autowired
    private EnrolService enrolService;

    @PostMapping
    public ResponseEntity<Enrol> createEnrol(@RequestBody Enrol enrol) {
        return new ResponseEntity<>(enrolService.saveEnrol(enrol), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enrol> enrol(@PathVariable Long id) {
        Optional<Enrol> enrol = enrolService.findEnrolById(id);
        return enrol.map(enrolEntity -> new ResponseEntity<>(enrolEntity, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Enrol>> getAllEnrols() {
        return new ResponseEntity<>(enrolService.findAllEnrols(), HttpStatus.OK);
    }

    // Add more endpoints as needed
}
