package com.unisinos.portal_vagas.domain.service;

import com.unisinos.portal_vagas.domain.data.mapper.estudante.EstudanteMapper;
import com.unisinos.portal_vagas.domain.data.model.estudante.*;
import com.unisinos.portal_vagas.domain.data.model.vaga.Vaga;
import com.unisinos.portal_vagas.domain.exception.DataNotFoundException;
import com.unisinos.portal_vagas.domain.repositories.estudante.EstudanteRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstudanteService {

    private EstudanteRepository estudanteRepository;
    private EstudanteMapper estudanteMapper;
    private VagaService vagaService;
    private PasswordEncoder passwordEncoder;

    public EstudanteService(
            EstudanteRepository estudanteRepository,
            EstudanteMapper estudanteMapper,
            VagaService vagaService,
            PasswordEncoder passwordEncoder) {
        this.estudanteRepository = estudanteRepository;
        this.estudanteMapper = estudanteMapper;
        this.vagaService = vagaService;
        this.passwordEncoder = passwordEncoder;
    }

    public EstudanteResponse criarEstudante(EstudanteRequest estudanteRequest) {
        Estudante estudante = estudanteMapper.convertToEstudante(estudanteRequest);
        estudante.setRole("ESTUDANTE");
        estudante.setSenha(passwordEncoder.encode(estudante.getSenha()));
        return estudanteMapper.convertToEstudanteResponse(estudanteRepository.criar(estudante));
    }

    public EstudanteCandidatura criarCandidatura(String id, String idVaga) {
        Estudante estudante = validarEstudante(id);
        Vaga vaga = validarVaga(idVaga);
        EstudanteCandidatura candidatura = estudanteMapper.convertToEstudanteCandidatura(vaga);
        return estudanteRepository.criarCandidatura(estudante, candidatura);
    }

    public List<EstudanteResponse> listarEstudantes(EstudanteRequestFilter estudanteRequestFilter) {
        EstudanteFilter estudanteFilter = estudanteMapper.convertToEstudanteFilter(estudanteRequestFilter);
        return estudanteRepository.listarPorFiltro(estudanteFilter)
                .stream().map(estudanteMapper::convertToEstudanteResponse)
                .collect(Collectors.toList());
    }

    public Optional<EstudanteResponse> buscarEstudantePorId(String id) {
        return estudanteRepository.buscarPorId(id).map(estudanteMapper::convertToEstudanteResponse);
    }

    public EstudanteResponse atualizarEstudante(String id, EstudanteRequest estudanteRequest) {
        Estudante estudante = estudanteMapper.convertToEstudante(estudanteRequest);
        return estudanteMapper.convertToEstudanteResponse(estudanteRepository.atualizar(id, estudante));
    }

    public void deletarEstudante(String id) {
        estudanteRepository.deletar(id);
    }

    private Estudante validarEstudante(String id) {
        Optional<Estudante> estudante = estudanteRepository.buscarPorId(id);
        if (estudante.isEmpty()) {
            throw new DataNotFoundException(String.format("Estudante com id [%s] não encontrado", id));
        }
        return estudante.get();
    }

    private Vaga validarVaga(String id) {
        Optional<Vaga> vaga = vagaService.buscarVagaPorId(id);
        if (vaga.isEmpty()) {
            throw new DataNotFoundException(String.format("Vaga com id [%s] não encontrada", id));
        }
        return vaga.get();
    }
}
