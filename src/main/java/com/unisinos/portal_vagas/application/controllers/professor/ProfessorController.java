package com.unisinos.portal_vagas.application.controllers.professor;

import com.unisinos.portal_vagas.domain.data.model.professor.ProfessorRequestFilter;
import com.unisinos.portal_vagas.domain.data.model.professor.Professor;
import com.unisinos.portal_vagas.domain.data.model.professor.ProfessorRequest;
import com.unisinos.portal_vagas.domain.service.ProfessorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("portal-vagas/professores/v1/professores")
public class ProfessorController {

    private ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @PostMapping
    public ResponseEntity<Professor> criarPerfilProfessor(@RequestBody ProfessorRequest professorRequest) {
        Professor novoProfessor = professorService.criarProfessor(professorRequest);
        return new ResponseEntity<>(novoProfessor, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Professor>> listarProfessores(@RequestBody ProfessorRequestFilter professorRequestFilter) {
        List<Professor> professores = professorService.listarProfessores(professorRequestFilter);
        return new ResponseEntity<>(professores, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> buscarProfessorPorId(@PathVariable String id) {
        return professorService.buscarProfessorPorId(id)
                .map(professor -> new ResponseEntity<>(professor, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professor> atualizarPerfilProfessor(@PathVariable String id, @RequestBody ProfessorRequest professorRequest) {
        Professor professorAtualizado = professorService.atualizarProfessor(id, professorRequest);
        return new ResponseEntity<>(professorAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPerfilProfessor(@PathVariable String id) {
        professorService.deletarProfessor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
