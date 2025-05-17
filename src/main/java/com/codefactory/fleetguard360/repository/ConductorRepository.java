package com.codefactory.fleetguard360.repository;

import com.codefactory.fleetguard360.repository.entities.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConductorRepository extends JpaRepository<Conductor, Long> {
    Optional<Conductor> findByCorreo(String correo);
}
