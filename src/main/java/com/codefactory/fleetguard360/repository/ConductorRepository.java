package com.codefactory.fleetguard360.repository;

import com.codefactory.fleetguard360.repository.entities.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConductorRepository extends JpaRepository<Conductor, Integer> {
}
