package com.unisinos.portal_vagas.domain.repositories.estudante;

import com.unisinos.portal_vagas.domain.data.model.estudante.EstudanteFilter;
import com.unisinos.portal_vagas.domain.data.model.estudante.Estudante;

import java.util.List;
import java.util.Optional;

public interface EstudanteRepository {

    Estudante criarPerfilEstudante(Estudante estudante);

    List<Estudante> listarEstudantePorFiltro(EstudanteFilter estudanteFilter);

    Optional<Estudante> buscarPorId(String id);

    Estudante atualizar(String id, Estudante estudante);

    void deletar(String id);
}
