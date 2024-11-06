package com.unisinos.portal_vagas.infrasctucture.data.mapper.estudante;

import com.unisinos.portal_vagas.domain.data.model.estudante.Estudante;
import com.unisinos.portal_vagas.infrasctucture.data.model.document.estudante.EstudanteDocument;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EstudanteDocumentMapper {

    EstudanteDocument convertToEstudanteDocument(Estudante estudante);

    Estudante convertToEstudante(EstudanteDocument estudanteDocument);
}
