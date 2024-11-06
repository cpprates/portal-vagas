package com.unisinos.portal_vagas.domain.data.model.estudante;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class EstudanteRequest {

    @Schema(description = "Nome do estudante", example = "Maria Flor")
    @NotBlank
    private String nome;

    @Schema(description = "Registro Acadêmico (RA)", example = "12346532")
    @NotBlank
    private String registroAcademico;

    @Schema(description = "Nome do curso", example = "Ciência da Computação")
    @NotBlank
    private String curso;

    @Schema(description = "E-mail do estudante", example = "mariaflor@edu.unisinos.br")
    @NotBlank
    private String email;

    @Schema(description = "Lista de habilidades profissionais", example = "[\"proatividade\", \"vontade de aprender\"]")
    @NotBlank
    private List<String> habilidades;

    @Schema(description = "Tecnologias que possui conhecimento", example = "[\"Java\", \"SpringBoot\", \"MongoDB\"]")
    @NotBlank
    private List<String> tecnologias;

    @Schema(description = "Pequena apresentação pessoal", example = "Em busca de estágio focado em backend")
    @NotBlank
    private String textoApresentacao;

    @Schema(description = "Site de um perfil profissional", example = "https://linkedin.com/in/mariaflor/")
    @NotBlank
    private String site;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRegistroAcademico() {
        return registroAcademico;
    }

    public void setRegistroAcademico(String registroAcademico) {
        this.registroAcademico = registroAcademico;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getTextoApresentacao() {
        return textoApresentacao;
    }

    public void setTextoApresentacao(String textoApresentacao) {
        this.textoApresentacao = textoApresentacao;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
}
