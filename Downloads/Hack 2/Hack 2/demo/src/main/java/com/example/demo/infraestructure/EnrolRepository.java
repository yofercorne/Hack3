package com.example.demo.infraestructure;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.domain.Enrol;

public interface EnrolRepository extends JpaRepository<Enrol, Long> {
}
