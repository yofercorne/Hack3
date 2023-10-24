package com.example.demo.infraestructure;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Periodo;

public interface PeriodoRepository extends JpaRepository<Periodo, Long> {}