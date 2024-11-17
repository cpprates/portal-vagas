package com.unisinos.portal_vagas.domain.service;

import com.unisinos.portal_vagas.domain.data.model.professor.ProfessorFilter;
import com.unisinos.portal_vagas.domain.data.model.professor.ProfessorRequestFilter;
import com.unisinos.portal_vagas.domain.data.mapper.professor.ProfessorMapper;
import com.unisinos.portal_vagas.domain.data.model.professor.Professor;
import com.unisinos.portal_vagas.domain.data.model.professor.ProfessorRequest;
import com.unisinos.portal_vagas.domain.repositories.professor.ProfessorRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    private ProfessorRepository professorRepository;
    private ProfessorMapper professorMapper;
    private PasswordEncoder passwordEncoder;

    public ProfessorService(ProfessorRepository professorRepository, ProfessorMapper professorMapper, PasswordEncoder passwordEncoder) {
        this.professorRepository = professorRepository;
        this.professorMapper = professorMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public Professor criarProfessor(ProfessorRequest professorRequest) {
        Professor professor = professorMapper.convertToProfessor(professorRequest);
        professor.setRole(professor.isCoordenador() ? "ADMIN" : "PROFESSOR");
        professor.setSenha(passwordEncoder.encode(professor.getSenha()));
        return professorRepository.criarPerfil(professor);
    }

    public List<Professor> listarProfessores(ProfessorRequestFilter professorRequestFilter) {
        ProfessorFilter professorFilter = professorMapper.convertToProfessorFilter(professorRequestFilter);
        return professorRepository.listarProfessorPorFiltro(professorFilter);
    }

    public Optional<Professor> buscarProfessorPorId(String id) {
        return professorRepository.buscarPorId(id);
    }

    public Professor atualizarProfessor(String id, ProfessorRequest professorRequest) {
        Professor professor = professorMapper.convertToProfessor(professorRequest);
        return professorRepository.atualizar(id, professor);
    }

    public void deletarProfessor(String id) {
        professorRepository.deletar(id);
    }
}