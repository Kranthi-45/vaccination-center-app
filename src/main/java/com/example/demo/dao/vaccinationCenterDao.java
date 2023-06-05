package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.pacUser;
import com.example.demo.entity.vaccinationCenter;
import com.example.demo.repository.vaccinationCenterRepository;


@Repository
public class vaccinationCenterDao {
	
    private final vaccinationCenterRepository vaccinationCenterRepository;

    @Autowired
    public vaccinationCenterDao(vaccinationCenterRepository vaccinationCenterRepository) {
        this.vaccinationCenterRepository = vaccinationCenterRepository;
    }

    public vaccinationCenter create(vaccinationCenter vaccinationCenter) {
        return vaccinationCenterRepository.save(vaccinationCenter);
    }

    public List<vaccinationCenter> read() {
        return vaccinationCenterRepository.findAll();
    }

    public Optional<vaccinationCenter> read(Long id) {
        return vaccinationCenterRepository.findById(id);
    }
    

    public vaccinationCenter update(vaccinationCenter vaccinationCenter) {
        return vaccinationCenterRepository.save(vaccinationCenter);
    }

    public void delete(Long id) {
    	vaccinationCenterRepository.deleteById(id);
    }
}
