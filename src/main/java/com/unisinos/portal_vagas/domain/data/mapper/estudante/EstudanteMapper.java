package com.unisinos.portal_vagas.domain.data.mapper.estudante;

import com.unisinos.portal_vagas.domain.data.filters.estudante.EstudanteFilter;
import com.unisinos.portal_vagas.domain.data.filters.estudante.EstudanteRequestFilter;
import com.unisinos.portal_vagas.domain.data.model.estudante.Estudante;
import com.unisinos.portal_vagas.domain.data.model.estudante.EstudanteRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EstudanteMapper {

    Estudante convertToEstudante(EstudanteRequest estudanteRequest);

    EstudanteFilter convertToEstudanteFilter(EstudanteRequestFilter estudanteRequestFilter);
}
