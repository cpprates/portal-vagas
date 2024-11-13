package com.unisinos.portal_vagas.domain.data.mapper.estudante;

import com.unisinos.portal_vagas.domain.data.model.estudante.*;
import com.unisinos.portal_vagas.domain.data.model.vaga.Vaga;
import org.mapstruct.*;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EstudanteMapper {

    Estudante convertToEstudante(EstudanteRequest estudanteRequest);

    EstudanteCandidatura convertToEstudanteCandidatura(Vaga vaga);

    @AfterMapping
    default void setDataCandidatura(@MappingTarget EstudanteCandidatura estudanteCandidatura) {
        estudanteCandidatura.setDataCandidatura(LocalDateTime.now());
    }

    EstudanteFilter convertToEstudanteFilter(EstudanteRequestFilter estudanteRequestFilter);
}
