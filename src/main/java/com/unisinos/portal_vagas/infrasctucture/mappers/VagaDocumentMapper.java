package com.unisinos.portal_vagas.infrasctucture.mappers;

import com.unisinos.portal_vagas.domain.data.model.Vaga;
import com.unisinos.portal_vagas.infrasctucture.data.model.document.VagaDocument;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VagaDocumentMapper {

    VagaDocument convertToVagaDocument(Vaga vaga);

    Vaga convertToVaga(VagaDocument vagaDocument);
}
