package com.unisinos.portal_vagas.domain.service;

import com.unisinos.portal_vagas.domain.data.model.estudante.EstudanteFilter;
import com.unisinos.portal_vagas.domain.data.model.estudante.EstudanteRequestFilter;
import com.unisinos.portal_vagas.domain.data.mapper.estudante.EstudanteMapper;
import com.unisinos.portal_vagas.domain.data.model.estudante.Estudante;
import com.unisinos.portal_vagas.domain.data.model.estudante.EstudanteRequest;
import com.unisinos.portal_vagas.domain.repositories.estudante.EstudanteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudanteService {

    private EstudanteRepository estudanteRepository;
    private EstudanteMapper estudanteMapper;

    public EstudanteService(EstudanteRepository estudanteRepository, EstudanteMapper estudanteMapper) {
        this.estudanteRepository = estudanteRepository;
        this.estudanteMapper = estudanteMapper;
    }

    public Estudante criarPerfilEstudante(EstudanteRequest estudanteRequest) {
        Estudante estudante = estudanteMapper.convertToEstudante(estudanteRequest);
        return estudanteRepository.criarPerfilEstudante(estudante);
    }

    public List<Estudante> listar(EstudanteRequestFilter estudanteRequestFilter) {
        EstudanteFilter estudanteFilter = estudanteMapper.convertToEstudanteFilter(estudanteRequestFilter);
        return estudanteRepository.listarEstudantePorFiltro(estudanteFilter);
    }

    public Optional<Estudante> buscarEstudantePorId(String id) {
        return estudanteRepository.buscarPorId(id);
    }

    public Estudante atualizar(String id, EstudanteRequest estudanteRequest) {
        Estudante estudante = estudanteMapper.convertToEstudante(estudanteRequest);
        return estudanteRepository.atualizar(id, estudante);
    }

    public void deletar(String id) {
        estudanteRepository.deletar(id);
    }
}
