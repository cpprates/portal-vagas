package com.unisinos.portal_vagas.domain.service;

import com.unisinos.portal_vagas.infrasctucture.data.model.document.VagaDocument;
import com.unisinos.portal_vagas.infrasctucture.repository.persistance.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VagaService {
    @Autowired
    private VagaRepository vagaRepository;

    public VagaDocument salvar(VagaDocument vaga) {
        return vagaRepository.save(vaga);
    }

    public List<VagaDocument> listar() {
        return vagaRepository.findAll();
    }

    public Optional<VagaDocument> buscarPorId(String id) {
        return vagaRepository.findById(id);
    }

    public void deletar(String id) {
        vagaRepository.deleteById(id);
    }
}