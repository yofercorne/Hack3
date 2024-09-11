package com.example.demo.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.infraestructure.PeriodoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PeriodoService {

    @Autowired
    private PeriodoRepository periodoRepository;



    public Periodo savePeriodo(Periodo periodo) {
        return periodoRepository.save(periodo);
    }

    public Optional<Periodo> findPeriodoById(Long id) {
        return periodoRepository.findById(id);
    }

    public List<Periodo> findAllPeriodos() {
        return periodoRepository.findAll();
    }


    public Optional<Periodo> getPeriodo(Long id) {
        return periodoRepository.findById(id);
    }


}

