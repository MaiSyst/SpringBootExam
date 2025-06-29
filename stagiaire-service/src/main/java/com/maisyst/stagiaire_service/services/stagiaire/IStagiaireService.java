package com.maisyst.stagiaire_service.services.stagiaire;

import com.maisyst.stagiaire_service.models.dto.StagiaireDto;
import com.maisyst.stagiaire_service.services.utils.MaiResponse;
import com.maisyst.stagiaire_service.models.Stagiaire;
import java.util.List;

public sealed interface IStagiaireService permits StagiaireServiceImpl {
    MaiResponse<Stagiaire> addStagiaire(StagiaireDto dto);
    MaiResponse<Boolean> removeStagiaire(long id);
    MaiResponse<Stagiaire> getOneStagiaire(long id);
    MaiResponse<List<Stagiaire>> getAllStagiaire();
    MaiResponse<Stagiaire> putStagiaire(StagiaireDto dto, long id);
}
