package com.unisinos.portal_vagas.domain.data.mapper;

import com.unisinos.portal_vagas.domain.data.filters.VagaFilter;
import com.unisinos.portal_vagas.domain.data.filters.VagaRequestFilter;
import com.unisinos.portal_vagas.domain.data.model.Vaga;
import com.unisinos.portal_vagas.domain.data.model.VagaRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VagaMapper {

    Vaga convertToVaga(VagaRequest vagaRequest);

    VagaFilter convertToVagaFilter(VagaRequestFilter vagaRequestFilter);
}
