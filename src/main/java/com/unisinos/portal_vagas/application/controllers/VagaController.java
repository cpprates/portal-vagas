package com.unisinos.portal_vagas.application.controllers;
import com.unisinos.portal_vagas.domain.service.VagaService;
import com.unisinos.portal_vagas.infrasctucture.data.model.document.VagaDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vagas")
public class VagaController {
    @Autowired
    private VagaService vagaService;

    @PostMapping
    public ResponseEntity<VagaDocument> criarVaga(@RequestBody VagaDocument vaga) {
        VagaDocument novaVaga = vagaService.salvar(vaga);
        return new ResponseEntity<>(novaVaga, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<VagaDocument>> listarVagas() {
        List<VagaDocument> vagas = vagaService.listar();
        return new ResponseEntity<>(vagas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VagaDocument> buscarVagaPorId(@PathVariable String id) {
        return vagaService.buscarPorId(id)
                .map(vaga -> new ResponseEntity<>(vaga, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VagaDocument> atualizarVaga(@PathVariable String id, @RequestBody VagaDocument vaga) {
        vaga.setId(id);
        VagaDocument vagaAtualizada = vagaService.salvar(vaga);
        return new ResponseEntity<>(vagaAtualizada, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVaga(@PathVariable String id) {
        vagaService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
