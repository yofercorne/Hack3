package com.example.demo.infraestructure;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {}