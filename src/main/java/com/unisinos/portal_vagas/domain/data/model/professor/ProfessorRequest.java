package com.unisinos.portal_vagas.domain.data.model.professor;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public class ProfessorRequest {

    @Schema(description = "Nome do professor", example = "João Carvalho")
    @NotBlank
    private String nome;

    @Schema(description = "E-mail para contato", example = "joaoc@unisinos.br")
    @NotBlank
    private String email;

    @Schema(description = "Curso de formacão", example = "Ciência da Computacão - PhD")
    @NotBlank
    private String formacao;

    @Schema(description = "Área que atua", example = "Banco de Dados")
    @NotBlank
    private String areaAtuacao;

    @Schema(description = "Departamento que trabalha", example = "Escola Politécnica")
    @NotBlank
    private String departamento;

    @Schema(description = "Se o professor é coordenador", example = "false")
    @NotBlank
    private boolean coordenador;

    @NotBlank
    private String senha;

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

    public @NotBlank String getSenha() {
        return senha;
    }

    public void setSenha(@NotBlank String senha) {
        this.senha = senha;
    }
}
