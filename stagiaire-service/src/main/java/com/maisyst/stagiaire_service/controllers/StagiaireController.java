package com.maisyst.stagiaire_service.controllers;

import com.maisyst.stagiaire_service.models.Stagiaire;
import com.maisyst.stagiaire_service.models.dto.StagiaireDto;
import com.maisyst.stagiaire_service.services.stagiaire.StagiaireServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stagiaires")
public record StagiaireController(StagiaireServiceImpl service) {

    @GetMapping("/{id}")
    ResponseEntity<Stagiaire> findOne(@PathVariable long id){
        final var result=service.getOneStagiaire(id);

        if(result.status()==HttpStatus.OK){
            return ResponseEntity.ok(result.data());
        }
        return new ResponseEntity<>(null,result.status());
    }
    @GetMapping
    ResponseEntity<List<Stagiaire>> findAll(){
        final var result=service.getAllStagiaire();

        if(result.status()==HttpStatus.OK){
            return ResponseEntity.ok(result.data());
        }
        return new ResponseEntity<>(null,result.status());
    }
    @PostMapping
    ResponseEntity<Stagiaire> addEncadreur(@RequestBody StagiaireDto body){
        final var result=service.addStagiaire(body);
        if(result.status()==HttpStatus.CREATED){
            return ResponseEntity.ok(result.data());
        }
        return new ResponseEntity<>(null,result.status());
    }
    @PutMapping("/{id}")
    ResponseEntity<Stagiaire> updateEncadreur(@PathVariable long id, @RequestBody StagiaireDto body){
        final var result=service.putStagiaire(body,id);
        if(result.status()==HttpStatus.OK){
            return ResponseEntity.ok(result.data());
        }
        return new ResponseEntity<>(null,result.status());
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> removeEncadreur(@PathVariable long id){
        final var result=service.removeStagiaire(id);
        if(result.status()==HttpStatus.OK){
            return ResponseEntity.ok("Stagiaire was been deleted.");
        }
        return new ResponseEntity<>("Stagiaire wasn't been deleted.",result.status());
    }
}
