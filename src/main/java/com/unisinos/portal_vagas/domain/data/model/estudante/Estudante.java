package com.unisinos.portal_vagas.domain.data.model.estudante;

import com.unisinos.portal_vagas.domain.data.model.UsuarioModel;

import java.util.List;

public class Estudante extends UsuarioModel {

    private String registroAcademico;
    private String curso;
    private List<String> habilidades;
    private List<String> tecnologias;
    private String textoApresentacao;
    private String site;
    private List<EstudanteCandidatura> candidaturas;

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
