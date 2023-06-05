package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.pacUser;
import com.example.demo.entity.citizens;
import com.example.demo.repository.citizensRepository;


@Repository
public class citizensDao {
	
    private final citizensRepository citizensRepository;

    @Autowired
    public citizensDao(citizensRepository citizensRepository) {
        this.citizensRepository = citizensRepository;
    }

    public citizens create(citizens citizens) {
        return citizensRepository.save(citizens);
    }

    public List<citizens> read() {
        return citizensRepository.findAll();
    }

    public Optional<citizens> read(Long id) {
        return citizensRepository.findById(id);
    }
    

    public citizens update(citizens citizens) {
        return citizensRepository.save(citizens);
    }

    public void delete(Long id) {
    	citizensRepository.deleteById(id);
    }
    
}
