package com.unisinos.portal_vagas.domain.service;

import com.unisinos.portal_vagas.domain.data.mapper.estudante.EstudanteMapper;
import com.unisinos.portal_vagas.domain.data.model.estudante.*;
import com.unisinos.portal_vagas.domain.data.model.vaga.Vaga;
import com.unisinos.portal_vagas.domain.exception.DataNotFoundException;
import com.unisinos.portal_vagas.domain.repositories.estudante.EstudanteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudanteService {

    private EstudanteRepository estudanteRepository;
    private EstudanteMapper estudanteMapper;
    private VagaService vagaService;

    public EstudanteService(
            EstudanteRepository estudanteRepository,
            EstudanteMapper estudanteMapper,
            VagaService vagaService) {
        this.estudanteRepository = estudanteRepository;
        this.estudanteMapper = estudanteMapper;
        this.vagaService = vagaService;
    }

    public Estudante criarEstudante(EstudanteRequest estudanteRequest) {
        Estudante estudante = estudanteMapper.convertToEstudante(estudanteRequest);
        return estudanteRepository.criar(estudante);
    }

    public EstudanteCandidatura criarCandidatura(String id, String idVaga) {
        Estudante estudante = validarEstudante(id);
        Vaga vaga = validarVaga(idVaga);
        EstudanteCandidatura candidatura = estudanteMapper.convertToEstudanteCandidatura(vaga);
        return estudanteRepository.criarCandidatura(estudante, candidatura);
    }

    public List<Estudante> listarEstudantes(EstudanteRequestFilter estudanteRequestFilter) {
        EstudanteFilter estudanteFilter = estudanteMapper.convertToEstudanteFilter(estudanteRequestFilter);
        return estudanteRepository.listarPorFiltro(estudanteFilter);
    }

    public Optional<Estudante> buscarEstudantePorId(String id) {
        return estudanteRepository.buscarPorId(id);
    }

    public Estudante atualizarEstudante(String id, EstudanteRequest estudanteRequest) {
        Estudante estudante = estudanteMapper.convertToEstudante(estudanteRequest);
        return estudanteRepository.atualizar(id, estudante);
    }

    public void deletarEstudante(String id) {
        estudanteRepository.deletar(id);
    }

    private Estudante validarEstudante(String id) {
        Optional<Estudante> estudante = buscarEstudantePorId(id);
        if (estudante.isEmpty()) {
            throw new DataNotFoundException(String.format("Estudante com id [{id}] não encontrado", id));
        }
        return estudante.get();
    }

    private Vaga validarVaga(String id) {
        Optional<Vaga> vaga = vagaService.buscarVagaPorId(id);
        if (vaga.isEmpty()) {
            throw new DataNotFoundException(String.format("Vaga com id [{id}] não encontrada", id));
        }
        return vaga.get();
    }
}
