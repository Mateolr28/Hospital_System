package com.hospital.hospital_management.service;

import com.hospital.hospital_management.model.Rol;
import com.hospital.hospital_management.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    public Rol findByName(String name) {
        return rolRepository.findByName(name);
    }

    public List<Rol> findAll() {
        return rolRepository.findAll();
    }
}
