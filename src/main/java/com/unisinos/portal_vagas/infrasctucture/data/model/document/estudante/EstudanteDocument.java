package com.unisinos.portal_vagas.infrasctucture.data.model.document.estudante;

import com.unisinos.portal_vagas.domain.data.model.estudante.EstudanteCandidatura;
import com.unisinos.portal_vagas.infrasctucture.data.model.document.usuario.Usuario;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "estudantes")
public class EstudanteDocument extends Usuario {

    @Indexed(unique = true)
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
