package com.unisinos.portal_vagas.domain.service;

import com.unisinos.portal_vagas.domain.data.mapper.vaga.VagaMapper;
import com.unisinos.portal_vagas.domain.data.model.vaga.Vaga;
import com.unisinos.portal_vagas.domain.data.model.vaga.VagaFilter;
import com.unisinos.portal_vagas.domain.data.model.vaga.VagaRequest;
import com.unisinos.portal_vagas.domain.data.model.vaga.VagaRequestFilter;
import com.unisinos.portal_vagas.domain.exception.DataNotFoundException;
import com.unisinos.portal_vagas.domain.repositories.vaga.VagaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VagaService {

    private VagaRepository vagaRepository;
    private VagaMapper vagaMapper;
    private ProfessorService professorService;

    public VagaService(VagaRepository vagaRepository, VagaMapper vagaMapper, ProfessorService professorService) {
        this.vagaRepository = vagaRepository;
        this.vagaMapper = vagaMapper;
        this.professorService = professorService;
    }

    public Vaga criarVaga(String idProfessor, VagaRequest vagaRequest) {
        validarProfessor(idProfessor);
        Vaga vaga = vagaMapper.convertToVaga(idProfessor, vagaRequest);
        return vagaRepository.criar(vaga);
    }

    public List<Vaga> listarVagas(VagaRequestFilter vagaRequestFilter) {
        VagaFilter vagaFilter = vagaMapper.convertToVagaFilter(vagaRequestFilter);
        return vagaRepository.buscarVagaPorFiltro(vagaFilter);
    }

    public Optional<Vaga> buscarVagaPorId(String id) {
        return Optional.ofNullable(vagaRepository.buscarPorId(id)
                .orElseThrow(() -> new DataNotFoundException("Vaga não encontrada")));
    }

    public Vaga atualizarVaga(String id, String idProfessor, VagaRequest vagaRequest) {
        Vaga vaga = vagaMapper.convertToVaga(id, vagaRequest);
        return vagaRepository.atualizar(id, idProfessor, vaga);
    }

    public void deletarVaga(String id, String idProfessor) {
        vagaRepository.deletar(id, idProfessor);
    }

    private void validarProfessor(String idProfessor) {
        if (professorService.buscarProfessorPorId(idProfessor).isEmpty()) {
            throw new DataNotFoundException(String.format("Professor com id [%s] não encontrado", idProfessor));
        }
    }
}