package com.unisinos.portal_vagas.domain.service;

import com.unisinos.portal_vagas.domain.data.mapper.professor.ProfessorMapper;
import com.unisinos.portal_vagas.domain.data.model.professor.*;
import com.unisinos.portal_vagas.domain.repositories.professor.ProfessorRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public ProfessorResponse criarProfessor(ProfessorRequest professorRequest) {
        Professor professor = professorMapper.convertToProfessor(professorRequest);
        professor.setRole(professor.isCoordenador() ? "ADMIN" : "PROFESSOR");
        professor.setSenha(passwordEncoder.encode(professor.getSenha()));
        return professorMapper.convertToProfessorResponse(professorRepository.criarPerfil(professor));
    }

    public List<ProfessorResponse> listarProfessores(ProfessorRequestFilter professorRequestFilter) {
        ProfessorFilter professorFilter = professorMapper.convertToProfessorFilter(professorRequestFilter);
        return professorRepository.listarProfessorPorFiltro(professorFilter)
                .stream().map(professorMapper::convertToProfessorResponse)
                .collect(Collectors.toList());
    }

    public Optional<ProfessorResponse> buscarProfessorPorId(String id) {
        return professorRepository.buscarPorId(id).map(professorMapper::convertToProfessorResponse);
    }

    public ProfessorResponse atualizarProfessor(String id, ProfessorRequest professorRequest) {
        Professor professor = professorMapper.convertToProfessor(professorRequest);
        return professorMapper.convertToProfessorResponse(professorRepository.atualizar(id, professor));
    }

    public void deletarProfessor(String id) {
        professorRepository.deletar(id);
    }
}