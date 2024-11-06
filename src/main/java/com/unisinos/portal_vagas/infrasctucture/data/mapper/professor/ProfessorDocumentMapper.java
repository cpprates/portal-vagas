package com.unisinos.portal_vagas.infrasctucture.data.mapper.professor;

import com.unisinos.portal_vagas.domain.data.model.professor.Professor;
import com.unisinos.portal_vagas.infrasctucture.data.model.document.professor.ProfessorDocument;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProfessorDocumentMapper {

    ProfessorDocument convertToProfessorDocument(Professor professor);

    Professor convertToProfessor(ProfessorDocument professorDocument);
}
