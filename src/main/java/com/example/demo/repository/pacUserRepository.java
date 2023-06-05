package com.example.demo.repository;

import com.example.demo.entity.pacUser;

import org.springframework.data.jpa.repository.JpaRepository;

public interface pacUserRepository extends JpaRepository<pacUser, Long> {
    pacUser findByName(String name);
    pacUser findByNameAndPassword(String name, String password);
}
