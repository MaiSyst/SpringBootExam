package com.maisyst.encadreur_service.services.encadreur;

import com.maisyst.encadreur_service.models.Encadreur;
import com.maisyst.encadreur_service.models.dto.EncadreurDto;
import com.maisyst.encadreur_service.repositories.EncadreurRepository;
import com.maisyst.encadreur_service.services.utils.MaiResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record EncadreurServiceImpl(EncadreurRepository repository) implements IEncadreurSevice {

    @Override
    public MaiResponse<Encadreur> addEncadreur(EncadreurDto dto) {
        try{
            final var encadreur=Encadreur
                    .builder()
                    .nom(dto.nom())
                    .prenom(dto.prenom())
                    .email(dto.email())
                    .telephone(dto.telephone())
                    .build();
            return new MaiResponse.MaiSuccess<>(repository.save(encadreur),HttpStatus.CREATED);
        }catch(Exception e){
            return new MaiResponse.MaiError<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public MaiResponse<Boolean> removeEncadreur(long id) {
        try{
            final var result=repository.findById(id);
            if(result.isPresent()){
                repository.delete(result.get());
                return new MaiResponse.MaiSuccess<>(true,HttpStatus.OK);
            }
            return new MaiResponse.MaiError<>("Encadreur not found",HttpStatus.NOT_FOUND);

        }catch(Exception e){
            return new MaiResponse.MaiError<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public MaiResponse<Encadreur> getOneEncadreur(long id) {
        try{
            final var result=repository.findById(id);
            if(result.isPresent()){
                return new MaiResponse.MaiSuccess<>(result.get(), HttpStatus.OK);
            }
            return new MaiResponse.MaiError<>("Encadreur not found", HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new MaiResponse.MaiError<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public MaiResponse<List<Encadreur>> getAllEncadreur() {
        try{
            return new MaiResponse.MaiSuccess<>(repository.findAll(),HttpStatus.OK);
        }catch (Exception e){
            return new MaiResponse.MaiError<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public MaiResponse<Encadreur> putEncadreur(EncadreurDto dto, long id) {
       try{
           final var result=repository.findById(id);
           if(result.isPresent()){
               Encadreur encadreur=result.get();
               BeanUtils.copyProperties(dto, encadreur);
               return new MaiResponse.MaiSuccess<>(repository.save(encadreur),HttpStatus.OK);
           }
           return new MaiResponse.MaiError<>("Encadreur not found",HttpStatus.NOT_FOUND);
       }catch (Exception e){
           return new MaiResponse.MaiError<>(e.getMessage(),HttpStatus.BAD_REQUEST);
       }
    }
}
