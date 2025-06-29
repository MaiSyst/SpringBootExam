package com.maisyst.encadreur_service.services.encadreur;

import com.maisyst.encadreur_service.models.Encadreur;
import com.maisyst.encadreur_service.models.dto.EncadreurDto;
import com.maisyst.encadreur_service.services.utils.MaiResponse;

import java.util.List;

public sealed interface IEncadreurSevice permits EncadreurServiceImpl {
    MaiResponse<Encadreur> addEncadreur(EncadreurDto dto);
    MaiResponse<Boolean> removeEncadreur(long id);
    MaiResponse<Encadreur> getOneEncadreur(long id);
    MaiResponse<List<Encadreur>> getAllEncadreur();
    MaiResponse<Encadreur> putEncadreur(EncadreurDto dto,long id);
}
