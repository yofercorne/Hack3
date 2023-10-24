package com.example.demo.domain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GenericEntityService<T> {

    @Autowired
    private CrudRepository<T, Long> repository;

    public T saveEntity(T entity) {
        return repository.save(entity);
    }

    public Optional<T> findEntityById(Long id) {
        return repository.findById(id);
    }

    public List<T> findAllEntities() {
        return (List<T>) repository.findAll();
    }

    public Optional<T> getEntity(Long id) {
        return repository.findById(id);
    }
}
