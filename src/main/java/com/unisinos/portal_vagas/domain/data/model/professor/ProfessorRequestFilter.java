package com.unisinos.portal_vagas.domain.data.model.professor;

import io.swagger.v3.oas.annotations.media.Schema;

public class ProfessorRequestFilter {

    @Schema(description = "Nome do professor", example = "José Campos")
    private String nome;

    @Schema(description = "E-mail do professor", example = "jcampos@unisinos.br")
    private String email;

    @Schema(description = "Curso de formacão", example = "Ciência da Computacão - PhD")
    private String formacao;

    @Schema(description = "Área que atua", example = "Banco de Dados")
    private String areaAtuacao;

    @Schema(description = "Departamento que trabalha", example = "Escola Politécnica")
    private String departamento;

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
}
