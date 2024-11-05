package com.unisinos.portal_vagas.infrasctucture.mappers.vaga;

import com.unisinos.portal_vagas.domain.data.model.vaga.Vaga;
import com.unisinos.portal_vagas.infrasctucture.data.model.document.vaga.VagaDocument;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VagaDocumentMapper {

    VagaDocument convertToVagaDocument(Vaga vaga);

    Vaga convertToVaga(VagaDocument vagaDocument);
}
