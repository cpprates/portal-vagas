package com.unisinos.portal_vagas.domain.data.mapper.vaga;

import com.unisinos.portal_vagas.domain.data.filters.vaga.VagaFilter;
import com.unisinos.portal_vagas.domain.data.filters.vaga.VagaRequestFilter;
import com.unisinos.portal_vagas.domain.data.model.vaga.Vaga;
import com.unisinos.portal_vagas.domain.data.model.vaga.VagaRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VagaMapper {

    Vaga convertToVaga(VagaRequest vagaRequest);

    VagaFilter convertToVagaFilter(VagaRequestFilter vagaRequestFilter);
}
