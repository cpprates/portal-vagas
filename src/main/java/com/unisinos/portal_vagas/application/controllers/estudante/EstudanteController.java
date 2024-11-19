package com.unisinos.portal_vagas.application.controllers.estudante;

import com.unisinos.portal_vagas.domain.data.model.estudante.EstudanteCandidatura;
import com.unisinos.portal_vagas.domain.data.model.estudante.EstudanteRequest;
import com.unisinos.portal_vagas.domain.data.model.estudante.EstudanteRequestFilter;
import com.unisinos.portal_vagas.domain.data.model.estudante.EstudanteResponse;
import com.unisinos.portal_vagas.domain.service.EstudanteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("portal-vagas/estudantes/v1/estudantes")
public class EstudanteController {

    private final EstudanteService estudanteService;

    public EstudanteController(EstudanteService estudanteService) {
        this.estudanteService = estudanteService;
    }

    @PostMapping
    public ResponseEntity<EstudanteResponse> criarEstudante(@RequestBody EstudanteRequest estudanteRequest) {
        EstudanteResponse novoEstudante = estudanteService.criarEstudante(estudanteRequest);
        return new ResponseEntity<>(novoEstudante, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EstudanteResponse>> listarEstudantes(EstudanteRequestFilter estudanteRequestFilter) {
        List<EstudanteResponse> estudantes = estudanteService.listarEstudantes(estudanteRequestFilter);
        return new ResponseEntity<>(estudantes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstudanteResponse> buscarEstudantePorId(@PathVariable String id) {
        return estudanteService.buscarEstudantePorId(id)
                .map(estudante -> new ResponseEntity<>(estudante, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstudanteResponse> atualizarEstudante(@PathVariable String id, @RequestBody EstudanteRequest estudanteRequest) {
        EstudanteResponse estudanteAtualizado = estudanteService.atualizarEstudante(id, estudanteRequest);
        return new ResponseEntity<>(estudanteAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEstudante(@PathVariable String id) {
        estudanteService.deletarEstudante(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{id}/candidatura/{idVaga}")
    public ResponseEntity<EstudanteCandidatura> criarCandidatura(@PathVariable String id, @PathVariable String idVaga) {
        EstudanteCandidatura novaCandidatura = estudanteService.criarCandidatura(id, idVaga);
        return new ResponseEntity<>(novaCandidatura, HttpStatus.CREATED);
    }
}
