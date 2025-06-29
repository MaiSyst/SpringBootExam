package com.maisyst.stagiaire_service.services.stagiaire;

import com.maisyst.stagiaire_service.models.Stagiaire;
import com.maisyst.stagiaire_service.models.dto.StagiaireDto;
import com.maisyst.stagiaire_service.repositories.StagiareRepository;
import com.maisyst.stagiaire_service.services.utils.MaiResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record StagiaireServiceImpl(StagiareRepository repository) implements IStagiaireService {

    @Override
    public MaiResponse<Stagiaire> addStagiaire(StagiaireDto dto) {
        try{
            final var stagiaire= Stagiaire
                    .builder()
                    .nom(dto.nom())
                    .prenom(dto.prenom())
                    .email(dto.email())
                    .dateDebut(dto.dateDebut())
                    .dateFin(dto.dateFin())
                    .encadreurId(dto.encadreurId())
                    .build();
            return new MaiResponse.MaiSuccess<>(repository.save(stagiaire),HttpStatus.CREATED);
        }catch(Exception e){
            return new MaiResponse.MaiError<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public MaiResponse<Boolean> removeStagiaire(long id) {
        try{
            final var result=repository.findById(id);
            if(result.isPresent()){
                repository.delete(result.get());
                return new MaiResponse.MaiSuccess<>(true,HttpStatus.OK);
            }
            return new MaiResponse.MaiError<>("Stagiaire not found",HttpStatus.NOT_FOUND);

        }catch(Exception e){
            return new MaiResponse.MaiError<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public MaiResponse<Stagiaire> getOneStagiaire(long id) {
        try{
            final var result=repository.findById(id);
            if(result.isPresent()){
                return new MaiResponse.MaiSuccess<>(result.get(), HttpStatus.OK);
            }
            return new MaiResponse.MaiError<>("Stagiaire not found", HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new MaiResponse.MaiError<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public MaiResponse<List<Stagiaire>> getAllStagiaire() {
        try{
            return new MaiResponse.MaiSuccess<>(repository.findAll(),HttpStatus.OK);
        }catch (Exception e){
            return new MaiResponse.MaiError<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public MaiResponse<Stagiaire> putStagiaire(StagiaireDto dto, long id) {
       try{
           final var result=repository.findById(id);
           if(result.isPresent()){
               Stagiaire stagiaire=result.get();
               BeanUtils.copyProperties(dto, stagiaire);
               return new MaiResponse.MaiSuccess<>(repository.save(stagiaire),HttpStatus.OK);
           }
           return new MaiResponse.MaiError<>("Stagiaire not found",HttpStatus.NOT_FOUND);
       }catch (Exception e){
           return new MaiResponse.MaiError<>(e.getMessage(),HttpStatus.BAD_REQUEST);
       }
    }
}
