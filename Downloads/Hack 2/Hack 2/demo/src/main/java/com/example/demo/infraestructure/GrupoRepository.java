package com.example.demo.infraestructure;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Grupo;
public interface GrupoRepository extends JpaRepository<Grupo, Long> {}