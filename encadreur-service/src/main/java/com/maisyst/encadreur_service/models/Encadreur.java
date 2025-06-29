package com.maisyst.encadreur_service.models;

import jakarta.persistence.*;
import lombok.*;


@Entity()
@Getter
@Setter
@ToString
@AllArgsConstructor()
@NoArgsConstructor()
@Builder()
public class Encadreur {
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
    private String telephone;
}
