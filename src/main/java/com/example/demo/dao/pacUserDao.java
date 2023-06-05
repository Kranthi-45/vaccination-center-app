package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.pacUser;
import com.example.demo.repository.pacUserRepository;


@Repository
public class pacUserDao {
	
    private final pacUserRepository pacUserRepository;

    @Autowired
    public pacUserDao(pacUserRepository pacUserRepository) {
        this.pacUserRepository = pacUserRepository;
    }

    public pacUser create(pacUser pacUser) {
        return pacUserRepository.save(pacUser);
    }

    public List<pacUser> read() {
        return pacUserRepository.findAll();
    }

    public Optional<pacUser> read(Long id) {
        return pacUserRepository.findById(id);
    }
    
    public pacUser read(String name) {
        return pacUserRepository.findByName(name);
    }

    public pacUser update(pacUser pacUser) {
        return pacUserRepository.save(pacUser);
    }

    public void delete(Long id) {
    	pacUserRepository.deleteById(id);
    }
    
    public pacUser fetchUserByNameAndPassword(String name, String password) {
        return pacUserRepository.findByNameAndPassword(name, password);
    }
}
