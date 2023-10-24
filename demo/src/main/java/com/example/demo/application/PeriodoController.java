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

import com.example.demo.domain.Periodo;
import com.example.demo.domain.GenericEntityService;

@RestController
@RequestMapping("/periodos")
public class PeriodoController {

    @Autowired
    private GenericEntityService<Periodo> periodoService;  

    @PostMapping
    public ResponseEntity<Periodo> createPeriodo(@RequestBody Periodo periodo) {
        return new ResponseEntity<>(periodoService.saveEntity(periodo), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Periodo>> getAllPeriodos() {
        return new ResponseEntity<>(periodoService.findAllEntities(), HttpStatus.OK);
    }
}
