package com.example.demo.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.infraestructure.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;


    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    public Optional<Person> findPersonById(Long id) {
        return personRepository.findById(id);
    }

    public List<Person> findAllPersons() {
        return personRepository.findAll();
    }

    public boolean hasGrupos(Long id) {
        Optional<Person> personOptional = personRepository.findById(id);
        return personOptional.map(person -> !person.getGrupos().isEmpty()).orElse(false);
    }

    public Optional<Person> getPerson(Long id) {
        return personRepository.findById(id);
    }

  
   
}
