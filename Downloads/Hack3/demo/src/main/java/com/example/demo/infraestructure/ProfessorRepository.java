package com.example.demo.infraestructure;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {}