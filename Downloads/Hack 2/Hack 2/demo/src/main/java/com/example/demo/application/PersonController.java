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
@RequestMapping("/persons")
@CrossOrigin(origins = "http://localhost:3000")

public class PersonController {

    @Autowired
    private PersonService personService;
    @Autowired
    private GrupoService grupoService;

    @Autowired
    private EnrolService enrolService;

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        return new ResponseEntity<>(personService.savePerson(person), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> person(@PathVariable Long id) {
        Optional<Person> person = personService.findPersonById(id);
        return new ResponseEntity<>(person.get(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAllPersons() {
        return new ResponseEntity<>(personService.findAllPersons(), HttpStatus.OK);
    }

    @GetMapping("/groups/{personId}")
    public ResponseEntity<List<Grupo>> getGroupsForPerson(@PathVariable Long personId) {
        Optional<Person> person = personService.findPersonById(personId);

        if (person.isPresent()) {
            List<Grupo> groupsForPerson = new ArrayList<>(person.get().getGrupos());
            return new ResponseEntity<>(groupsForPerson, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/enroll/{personId}/{groupId}")
    public ResponseEntity<Enrol> enrollPersonInGroup(@PathVariable Long personId, @PathVariable Long groupId) {
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