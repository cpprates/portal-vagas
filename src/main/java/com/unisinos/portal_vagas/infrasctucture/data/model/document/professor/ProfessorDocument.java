package com.unisinos.portal_vagas.infrasctucture.data.model.document.professor;

import com.unisinos.portal_vagas.infrasctucture.data.model.document.usuario.Usuario;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "professores")
public class ProfessorDocument extends Usuario {

    private String formacao;
    private String areaAtuacao;
    private String departamento;
    private boolean coordenador;

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
