package com.unisinos.portal_vagas.domain.data.model.vaga;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public class VagaRequest {

    @Schema(description = "Título da vaga", example = "Desenvolvedor Junior - Java")
    @NotBlank
    private String titulo;

    @Schema(description = "Descricão da vaga", example = "Vaga de Desenvolvedor com experiência em Java")
    @NotBlank
    private String descricao;

    @Schema(description = "Empresa que oferece a vaga", example = "UniXS")
    @NotBlank
    private String empresa;

    @Schema(description = "Local de trabalho", example = "Porto Alegre")
    @NotBlank
    private String localizacao;

    public @NotBlank String getTitulo() {
        return titulo;
    }

    public void setTitulo(@NotBlank String titulo) {
        this.titulo = titulo;
    }

    public @NotBlank String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotBlank String descricao) {
        this.descricao = descricao;
    }

    public @NotBlank String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(@NotBlank String empresa) {
        this.empresa = empresa;
    }

    public @NotBlank String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(@NotBlank String localizacao) {
        this.localizacao = localizacao;
    }
}
