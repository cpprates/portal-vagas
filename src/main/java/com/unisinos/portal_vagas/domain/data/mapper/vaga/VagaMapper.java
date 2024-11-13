package com.unisinos.portal_vagas.domain.data.mapper.vaga;

import com.unisinos.portal_vagas.domain.data.model.vaga.VagaFilter;
import com.unisinos.portal_vagas.domain.data.model.vaga.VagaRequestFilter;
import com.unisinos.portal_vagas.domain.data.model.vaga.Vaga;
import com.unisinos.portal_vagas.domain.data.model.vaga.VagaRequest;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VagaMapper {

    Vaga convertToVaga(String idProfessor, VagaRequest vagaRequest);

    VagaFilter convertToVagaFilter(VagaRequestFilter vagaRequestFilter);

    @AfterMapping
    default void setDataCriacaoVaga(@MappingTarget Vaga vaga) {
        vaga.setDataCriacao(LocalDateTime.now());
    }
}
