package com.unisinos.portal_vagas.domain.repositories.professor;

import com.unisinos.portal_vagas.domain.data.filters.professor.ProfessorFilter;
import com.unisinos.portal_vagas.domain.data.model.professor.Professor;

import java.util.List;
import java.util.Optional;

public interface ProfessorRepository {

    Professor criarPerfil(Professor professor);

    List<Professor> listarProfessorPorFiltro(ProfessorFilter professorFilter);

    Optional<Professor> buscarPorId(String id);

    Professor atualizar(String id, Professor professor);

    void deletar(String id);
}