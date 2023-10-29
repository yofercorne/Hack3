package com.example.demo.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.infraestructure.ProfessorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public Professor saveProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    public Optional<Professor> findProfessorById(Long id) {
        return professorRepository.findById(id);
    }

    public List<Professor> findAllProfessors() {
        return professorRepository.findAll();
    }


    public Optional<Professor> getProfessor(Long id) {
        return professorRepository.findById(id);
    }


}

