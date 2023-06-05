package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.citizens;

public interface citizensRepository extends JpaRepository<citizens, Long> {

}
