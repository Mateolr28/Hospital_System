package com.hospital.hospital_management.repository;

import com.hospital.hospital_management.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Long> {
    Rol findByName(String name);
}
