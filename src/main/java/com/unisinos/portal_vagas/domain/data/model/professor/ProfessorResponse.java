package com.unisinos.portal_vagas.domain.data.model.professor;

import io.swagger.v3.oas.annotations.media.Schema;

public class ProfessorResponse {

    private String id;

    @Schema(description = "Nome do professor", example = "João Carvalho")
    private String nome;

    @Schema(description = "E-mail para contato", example = "joaoc@unisinos.br")
    private String email;

    @Schema(description = "Curso de formação", example = "Ciência da Computação - PhD")
    private String formacao;

    @Schema(description = "Área que atua", example = "Banco de Dados")
    private String areaAtuacao;

    @Schema(description = "Departamento que trabalha", example = "Escola Politécnica")
    private String departamento;

    @Schema(description = "Se o professor é coordenador", example = "false")
    private boolean coordenador;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public boolean isCoordenador() {
        return coordenador;
    }

    public void setCoordenador(boolean coordenador) {
        this.coordenador = coordenador;
    }
}
