package com.unisinos.portal_vagas.domain.data.model.estudante;

import java.util.List;

public class EstudanteResponse {

    private String id;
    private String nome;
    private String email;
    private String registroAcademico;
    private String curso;
    private List<String> habilidades;
    private List<String> tecnologias;
    private String textoApresentacao;
    private String site;
    private List<EstudanteCandidatura> candidaturas;

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

    public List<EstudanteCandidatura> getCandidaturas() {
        return candidaturas;
    }

    public void setCandidaturas(List<EstudanteCandidatura> candidaturas) {
        this.candidaturas = candidaturas;
    }
}
