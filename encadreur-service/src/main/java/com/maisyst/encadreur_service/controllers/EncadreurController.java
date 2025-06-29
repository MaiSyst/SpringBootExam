package com.maisyst.encadreur_service.controllers;

import com.maisyst.encadreur_service.models.Encadreur;
import com.maisyst.encadreur_service.models.dto.EncadreurDto;
import com.maisyst.encadreur_service.services.encadreur.EncadreurServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/encadreurs")
public record EncadreurController(EncadreurServiceImpl service) {

    @GetMapping("/{id}")
    ResponseEntity<Encadreur> findOne(@PathVariable long id){
        final var result=service.getOneEncadreur(id);

        if(result.status()==HttpStatus.OK){
            return ResponseEntity.ok(result.data());
        }
        return new ResponseEntity<>(null,result.status());
    }
    @GetMapping
    ResponseEntity<List<Encadreur>> findAll(){
        final var result=service.getAllEncadreur();

        if(result.status()==HttpStatus.OK){
            return ResponseEntity.ok(result.data());
        }
        return new ResponseEntity<>(null,result.status());
    }
    @PostMapping
    ResponseEntity<Encadreur> addEncadreur(@RequestBody EncadreurDto body){
        final var result=service.addEncadreur(body);
        if(result.status()==HttpStatus.CREATED){
            return ResponseEntity.ok(result.data());
        }
        return new ResponseEntity<>(null,result.status());
    }
    @PutMapping("/{id}")
    ResponseEntity<Encadreur> updateEncadreur(@PathVariable long id, @RequestBody EncadreurDto body){
        final var result=service.putEncadreur(body,id);
        if(result.status()==HttpStatus.OK){
            return ResponseEntity.ok(result.data());
        }
        return new ResponseEntity<>(null,result.status());
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> removeEncadreur(@PathVariable long id){
        final var result=service.removeEncadreur(id);
        if(result.status()==HttpStatus.OK){
            return ResponseEntity.ok("Encadreur was been deleted.");
        }
        return new ResponseEntity<>("Encadreur wasn't been deleted.",result.status());
    }
}
