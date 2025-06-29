package com.maisyst.stagiaire_service.repositories;

import com.maisyst.stagiaire_service.models.Stagiaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StagiareRepository extends JpaRepository<Stagiaire,Long> {
}
