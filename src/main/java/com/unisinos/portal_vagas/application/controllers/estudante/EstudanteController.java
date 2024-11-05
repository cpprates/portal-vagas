package com.unisinos.portal_vagas.application.controllers.estudante;

import com.unisinos.portal_vagas.domain.data.filters.estudante.EstudanteRequestFilter;
import com.unisinos.portal_vagas.domain.data.model.estudante.Estudante;
import com.unisinos.portal_vagas.domain.data.model.estudante.EstudanteRequest;
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
    public ResponseEntity<Estudante> criarPerfilEstudante(@RequestBody EstudanteRequest estudanteRequest) {
        Estudante novoEstudante = estudanteService.criarPerfilEstudante(estudanteRequest);
        return new ResponseEntity<>(novoEstudante, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Estudante>> listarEstudantes(EstudanteRequestFilter estudanteRequestFilter) {
        List<Estudante> estudantes = estudanteService.listar(estudanteRequestFilter);
        return new ResponseEntity<>(estudantes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudante> buscarEstudantePorId(@PathVariable String id) {
        return estudanteService.buscarEstudantePorId(id)
                .map(estudante -> new ResponseEntity<>(estudante, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudante> atualizarPerfilEstudante(@PathVariable String id, @RequestBody EstudanteRequest estudanteRequest) {
        Estudante estudanteAtualizado = estudanteService.atualizar(id, estudanteRequest);
        return new ResponseEntity<>(estudanteAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPerfilEstudante(@PathVariable String id) {
        estudanteService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
