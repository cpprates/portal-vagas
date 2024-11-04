package com.unisinos.portal_vagas.application.controllers;

import com.unisinos.portal_vagas.domain.data.filters.VagaRequestFilter;
import com.unisinos.portal_vagas.domain.data.model.Vaga;
import com.unisinos.portal_vagas.domain.data.model.VagaRequest;
import com.unisinos.portal_vagas.domain.service.VagaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("vagas/v1/vagas")
public class VagaController {

    private VagaService vagaService;

    public VagaController(VagaService vagaService) {
        this.vagaService = vagaService;
    }

    @PostMapping
    public ResponseEntity<Vaga> criarVaga(@RequestBody VagaRequest vagaRequest) {
        Vaga novaVaga = vagaService.salvar(vagaRequest);
        return new ResponseEntity<>(novaVaga, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Vaga>> listarVagas(VagaRequestFilter vagaRequestFilter) {
        List<Vaga> vagas = vagaService.listar(vagaRequestFilter);
        return new ResponseEntity<>(vagas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vaga> buscarVagaPorId(@PathVariable String id) {
        return vagaService.buscarPorId(id)
                .map(vaga -> new ResponseEntity<>(vaga, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vaga> atualizarVaga(@PathVariable String id, @RequestBody VagaRequest vagaRequest) {
        Vaga vagaAtualizada = vagaService.atualizar(id, vagaRequest);
        return new ResponseEntity<>(vagaAtualizada, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVaga(@PathVariable String id) {
        vagaService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
