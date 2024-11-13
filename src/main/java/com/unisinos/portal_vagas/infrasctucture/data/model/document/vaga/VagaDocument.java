package com.unisinos.portal_vagas.infrasctucture.data.model.document.vaga;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "vagas")
public class VagaDocument {
    @Id
    private String id;

    @Indexed(unique = true)
    private String titulo;

    private String descricao;
    private String empresa;
    private String localizacao;
    private LocalDateTime dataCriacao;
    private String idProfessor;
    private List<String> idCanditados;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getEmpresa() { return empresa; }
    public void setEmpresa(String empresa) { this.empresa = empresa; }

    public String getLocalizacao() { return localizacao; }
    public void setLocalizacao(String localizacao) { this.localizacao = localizacao; }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(String idProfessor) {
        this.idProfessor = idProfessor;
    }

    public List<String> getIdCanditados() {
        return idCanditados;
    }

    public void setIdCanditados(List<String> idCanditados) {
        this.idCanditados = idCanditados;
    }
}
