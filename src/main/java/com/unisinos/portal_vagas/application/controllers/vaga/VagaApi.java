package com.unisinos.portal_vagas.application.controllers.vaga;

import com.unisinos.portal_vagas.domain.data.model.estudante.EstudanteCandidatura;
import com.unisinos.portal_vagas.domain.data.model.vaga.Vaga;
import com.unisinos.portal_vagas.domain.data.model.vaga.VagaRequest;
import com.unisinos.portal_vagas.domain.data.model.vaga.VagaRequestFilter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static io.swagger.v3.oas.annotations.enums.ParameterIn.PATH;
import static io.swagger.v3.oas.annotations.enums.ParameterIn.QUERY;

public interface VagaApi {

    @Operation(summary = "Operação para criar vaga",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Created",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Vaga.class)
                            )),
                    @ApiResponse(
                            responseCode = "403",
                            description = "Forbidden",
                            content = @Content),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Not Found",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = {
                                            @ExampleObject(
                                                    name = "Professor não encontrado",
                                                    value = "{\"messages\":[\"Professor não encontrado\"]}")
                                    }
                            ))
            })
    ResponseEntity<Vaga> criarVaga(
            @Parameter(in = PATH, required = true, description = "Id do professor") String idProfessor,
            @RequestBody(
                    required = true,
                    content = @Content(schema = @Schema(
                            implementation = VagaRequest.class))) VagaRequest vagaRequest);

    @Operation(summary = "Operação para buscar vagas por filtro",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK",
                            content = @Content(
                                    array = @ArraySchema(schema = @Schema(implementation = Vaga[].class))
                            )),
                    @ApiResponse(
                            responseCode = "403",
                            description = "Forbidden",
                            content = @Content)
            })
    ResponseEntity<List<Vaga>> listarVagas(
            @Parameter(in = QUERY, content = @Content(schema = @Schema(
                    implementation = VagaRequestFilter.class))) VagaRequestFilter vagaRequestFilter);

    @Operation(summary = "Operação para buscar vaga por id",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Vaga.class)
                            )),
                    @ApiResponse(
                            responseCode = "403",
                            description = "Forbidden",
                            content = @Content),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Not Found",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = {
                                            @ExampleObject(
                                                    name = "Vaga não encontrada",
                                                    value = "{\"messages\":[\"Vaga não encontrada\"]}")
                                    }
                            ))
            })
    ResponseEntity<Vaga> buscarVagaPorId(
            @Parameter(in = PATH, required = true, description = "Id da vaga") String id);

    @Operation(summary = "Operação para atualizar vaga",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Vaga.class)
                            )),
                    @ApiResponse(
                            responseCode = "403",
                            description = "Forbidden",
                            content = @Content),
                    @ApiResponse(
                            responseCode = "409",
                            description = "Conflict",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = {
                                            @ExampleObject(name = "Conflito",
                                                    value = "{\"messages\":[\"Professor com id [673ba6ad0974490d72b52ed9] não pode alterar vaga com id [743ba6ad0974490d54b52uc3]\"]}")
                                    }
                            ))
            })
    ResponseEntity<Vaga> atualizarVaga(
            @Parameter(in = PATH, required = true, description = "Id da vaga") String id,
            @Parameter(in = PATH, required = true, description = "Id do professor") String idProfessor,
            @RequestBody(required = true,
                    content = @Content(schema = @Schema(
                            implementation = VagaRequest.class))) VagaRequest vagaRequest);

    @Operation(summary = "Operação para deletar vaga",
            responses = {
                    @ApiResponse(
                            responseCode = "204",
                            description = "No Content",
                            content = @Content),
                    @ApiResponse(
                            responseCode = "403",
                            description = "Forbidden",
                            content = @Content),
                    @ApiResponse(
                            responseCode = "409",
                            description = "Conflict",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = {
                                            @ExampleObject(name = "Conflito",
                                                    value = "{\"messages\":[\"Professor com id [673ba6ad0974490d72b52ed9] não pode alterar vaga com id [743ba6ad0974490d54b52uc3]\"]}")
                                    }
                            ))
            })
    ResponseEntity<Void> deletarVaga(
            @Parameter(in = PATH, required = true, description = "Id da vaga") String id,
            @Parameter(in = PATH, required = true, description = "Id do professor") String idProfessor);
}
