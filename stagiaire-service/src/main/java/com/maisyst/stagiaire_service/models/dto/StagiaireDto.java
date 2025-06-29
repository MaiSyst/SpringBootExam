package com.maisyst.stagiaire_service.models.dto;


import java.time.LocalDate;

public record StagiaireDto(String nom, String prenom, String email, LocalDate dateFin, LocalDate dateDebut,
                           Long encadreurId) { }
