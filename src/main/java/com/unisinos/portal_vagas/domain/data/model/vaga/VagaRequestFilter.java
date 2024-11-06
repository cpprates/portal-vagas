package com.unisinos.portal_vagas.domain.data.model.vaga;

import io.swagger.v3.oas.annotations.media.Schema;

public class VagaRequestFilter {

    @Schema(description = "Título da vaga", example = "Desenvolvedor")
    private String titulo;

    @Schema(description = "Empresa que oferece a vaga", example = "UniXS")
    private String empresa;

    @Schema(description = "Local de trabalho", example = "Porto Alegre")
    private String localizacao;

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
