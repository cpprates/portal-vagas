package com.unisinos.portal_vagas.domain.data.filters.estudante;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public class EstudanteRequestFilter {

    @Schema(description = "Nome do estudante", example = "Maria Flor")
    private String nome;

    @Schema(description = "Curso da univerisade", example = "Jogos Digitais")
    private String curso;

    @Schema(description = "Lista de habilidades profissionais", example = "[\"proatividade\", \"vontade de aprender\"]")
    private List<String> habilidades;

    @Schema(description = "Tecnologias que possui conhecimento", example = "[\"Java\", \"SpringBoot\", \"MongoDB\"]")
    private List<String> tecnologias;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    public List<String> getTecnologias() {
        return tecnologias;
    }

    public void setTecnologias(List<String> tecnologias) {
        this.tecnologias = tecnologias;
    }
}
