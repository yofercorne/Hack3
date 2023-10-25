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

import com.example.demo.domain.Professor;
import com.example.demo.domain.ProfessorService;
//import com.example.demo.domain.GenericEntityService;

@RestController
@RequestMapping("/proffesor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorservice;  

    @PostMapping
    public ResponseEntity<Professor> createProfessor(@RequestBody Professor periodo) {
        return new ResponseEntity<>(professorservice.saveProfessor(periodo), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Professor>> getAllProfessors() {
        return new ResponseEntity<>(professorservice.findAllProfessors(), HttpStatus.OK);
    }
}
