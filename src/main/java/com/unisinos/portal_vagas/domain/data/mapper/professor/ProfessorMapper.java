package com.unisinos.portal_vagas.domain.data.mapper.professor;

import com.unisinos.portal_vagas.domain.data.model.professor.ProfessorFilter;
import com.unisinos.portal_vagas.domain.data.model.professor.ProfessorRequestFilter;
import com.unisinos.portal_vagas.domain.data.model.professor.Professor;
import com.unisinos.portal_vagas.domain.data.model.professor.ProfessorRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProfessorMapper {

    Professor convertToProfessor(ProfessorRequest professorRequest);

    ProfessorFilter convertToProfessorFilter(ProfessorRequestFilter professorRequestFilter);
}
