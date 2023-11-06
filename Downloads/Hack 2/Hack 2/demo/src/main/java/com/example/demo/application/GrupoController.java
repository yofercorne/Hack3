package com.example.demo.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.Enrol;
import com.example.demo.domain.EnrolService;
import com.example.demo.domain.Grupo;
import com.example.demo.domain.GrupoService;
import com.example.demo.domain.Person;
import com.example.demo.domain.PersonService;

@RestController
@RequestMapping("/grupos")
@CrossOrigin(origins = "http://localhost:3000")
public class GrupoController {

    @Autowired
    private GrupoService grupoService;

     @Autowired
    private PersonService personService;
   
    @Autowired
    private EnrolService enrolService;

    @PostMapping
    public ResponseEntity<Grupo> createGrupo(@RequestBody Grupo grupo) {
        return new ResponseEntity<>(grupoService.saveGrupo(grupo), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Grupo> grupo(@PathVariable Long id) {
        Optional<Grupo> grupo = grupoService.findGrupoById(id);
        return new ResponseEntity<>(grupo.get(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Grupo>> getAllGrupos() {
        return new ResponseEntity<>(grupoService.findAllGrupos(), HttpStatus.OK);
    }
    @GetMapping("/persons/{groupId}")
    public ResponseEntity<List<Person>> getPersonsInGroup(@PathVariable Long groupId) {
        Optional<Grupo> grupo = grupoService.findGrupoById(groupId);

        if (grupo.isPresent()) {
            List<Person> personsInGroup = new ArrayList<>(grupo.get().getPersons());
            return new ResponseEntity<>(personsInGroup, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/enroll/{groupId}/{personId}")
    public ResponseEntity<Enrol> enrollPersonInGroup(@PathVariable Long groupId, @PathVariable Long personId) {
        Optional<Grupo> grupo = grupoService.findGrupoById(groupId);
        Optional<Person> person = personService.findPersonById(personId);

        if (grupo.isPresent() && person.isPresent()) {
            Enrol enrol = new Enrol(person.get(), grupo.get());
            return new ResponseEntity<>(enrolService.saveEnrol(enrol), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}