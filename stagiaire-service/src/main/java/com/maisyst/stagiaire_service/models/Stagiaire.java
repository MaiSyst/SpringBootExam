package com.maisyst.stagiaire_service.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity()
@Getter
@Setter
@ToString
@AllArgsConstructor()
@NoArgsConstructor()
@Builder()
public class Stagiaire {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String prenom;
    @Column(nullable = false,unique = true)
    private String email;
    @Column()
    private Long encadreurId;
    @Column(nullable = false)
    private LocalDate dateFin;
    @Column(nullable = false)
    private LocalDate dateDebut;
}
