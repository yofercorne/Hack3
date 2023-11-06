package com.example.demo.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.infraestructure.GrupoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GrupoService {

    @Autowired
    private GrupoRepository grupoRepository;



    public Grupo saveGrupo(Grupo grupo) {
        return grupoRepository.save(grupo);
    }

    public Optional<Grupo> findGrupoById(Long id) {
        return grupoRepository.findById(id);
    }

    public List<Grupo> findAllGrupos() {
        return grupoRepository.findAll();
    }

    public boolean hasPersons(Long id) {
        Optional<Grupo> grupoOptional = grupoRepository.findById(id);
        return grupoOptional.map(grupo -> !grupo.getPersons().isEmpty()).orElse(false);
    }

    public Optional<Grupo> getGrupo(Long id) {
        return grupoRepository.findById(id);
    }


}
