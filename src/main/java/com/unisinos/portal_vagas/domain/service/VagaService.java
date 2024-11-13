package com.unisinos.portal_vagas.domain.service;

import com.unisinos.portal_vagas.domain.data.model.vaga.VagaFilter;
import com.unisinos.portal_vagas.domain.data.model.vaga.VagaRequestFilter;
import com.unisinos.portal_vagas.domain.data.mapper.vaga.VagaMapper;
import com.unisinos.portal_vagas.domain.data.model.vaga.Vaga;
import com.unisinos.portal_vagas.domain.data.model.vaga.VagaRequest;
import com.unisinos.portal_vagas.domain.repositories.vaga.VagaRepository;
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

    public Vaga criarVaga(String idProfessor, VagaRequest vagaRequest) {
        Vaga vaga = vagaMapper.convertToVaga(idProfessor, vagaRequest);
        return vagaRepository.criar(vaga);
    }

    public List<Vaga> listarVagas(VagaRequestFilter vagaRequestFilter) {
        VagaFilter vagaFilter = vagaMapper.convertToVagaFilter(vagaRequestFilter);
        return vagaRepository.buscarVagaPorFiltro(vagaFilter);
    }

    public Optional<Vaga> buscarVagaPorId(String id) {
        return vagaRepository.buscarPorId(id);
    }

    public Vaga atualizarVaga(String id, VagaRequest vagaRequest) {
        Vaga vaga = vagaMapper.convertToVaga(id, vagaRequest);
        return vagaRepository.atualizar(id, vaga);
    }

    public void deletarVaga(String id) {
        vagaRepository.deletar(id);
    }
}