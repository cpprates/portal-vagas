package com.unisinos.portal_vagas.domain.repositories.vaga;

import com.unisinos.portal_vagas.domain.data.model.vaga.VagaFilter;
import com.unisinos.portal_vagas.domain.data.model.vaga.Vaga;

import java.util.List;
import java.util.Optional;

public interface VagaRepository {
    Vaga criar(Vaga vaga);

    List<Vaga> buscarVagaPorFiltro(VagaFilter vagaFilter);

    Optional<Vaga> buscarPorId(String id);

    Vaga atualizar(String id, String idProfessor, Vaga vaga);

    void deletar(String id, String idProfessor);
}
