package com.unisinos.portal_vagas.domain.service;

import com.unisinos.portal_vagas.domain.data.filters.VagaFilter;
import com.unisinos.portal_vagas.domain.data.filters.VagaRequestFilter;
import com.unisinos.portal_vagas.domain.data.mapper.VagaMapper;
import com.unisinos.portal_vagas.domain.data.model.Vaga;
import com.unisinos.portal_vagas.domain.data.model.VagaRequest;
import com.unisinos.portal_vagas.domain.repositories.VagaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VagaService {

    private VagaRepository vagaRepository;
    private VagaMapper vagaMapper;

    public VagaService(VagaRepository vagaRepository, VagaMapper vagaMapper) {
        this.vagaRepository = vagaRepository;
        this.vagaMapper = vagaMapper;
    }

    public Vaga salvar(VagaRequest vagaRequest) {
        Vaga vaga = vagaMapper.convertToVaga(vagaRequest);
        return vagaRepository.criar(vaga);
    }

    public List<Vaga> listar(VagaRequestFilter vagaRequestFilter) {
        VagaFilter vagaFilter = vagaMapper.convertToVagaFilter(vagaRequestFilter);
        return vagaRepository.buscarVagaPorFiltro(vagaFilter);
    }

    public Optional<Vaga> buscarPorId(String id) {
        return vagaRepository.buscarPorId(id);
    }

    public Vaga atualizar(String id, VagaRequest vagaRequest) {
        Vaga vaga = vagaMapper.convertToVaga(vagaRequest);
        return vagaRepository.atualizar(id, vaga);
    }

    public void deletar(String id) {
        vagaRepository.deletar(id);
    }
}