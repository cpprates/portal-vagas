package com.unisinos.portal_vagas.application.controllers.estudante;

import com.unisinos.portal_vagas.domain.data.model.estudante.EstudanteCandidatura;
import com.unisinos.portal_vagas.domain.data.model.estudante.EstudanteRequest;
import com.unisinos.portal_vagas.domain.data.model.estudante.EstudanteRequestFilter;
import com.unisinos.portal_vagas.domain.data.model.estudante.EstudanteResponse;
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

public interface EstudanteApi {

    @Operation(summary = "Operação para criar estudante",
            responses = {
                @ApiResponse(
                        responseCode = "201",
                        description = "Created",
                        content = @Content(
                                mediaType = MediaType.APPLICATION_JSON_VALUE,
                                schema = @Schema(implementation = EstudanteResponse.class)
                        ))
            })
    ResponseEntity<EstudanteResponse> criarEstudante(
            @RequestBody(
                    required = true,
                    content = @Content(schema = @Schema(
                            implementation = EstudanteRequest.class))) EstudanteRequest estudanteRequest);

    @Operation(summary = "Operação para buscar estudantes por filtro",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK",
                            content = @Content(
                                    array = @ArraySchema(schema = @Schema(implementation = EstudanteResponse[].class))
                            )),
                    @ApiResponse(
                            responseCode = "403",
                            description = "Forbidden",
                            content = @Content)
            })
    ResponseEntity<List<EstudanteResponse>> listarEstudantes(
            @Parameter(in = QUERY, content = @Content(schema = @Schema(
                    implementation = EstudanteRequestFilter.class))) EstudanteRequestFilter estudanteRequestFilter);

    @Operation(summary = "Operação para buscar estudante por id",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = EstudanteResponse.class)
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
                                                    name = "Estudante não encontrado",
                                                    value = "{\"messages\":[\"Estudante não encontrado\"]}")
                                    }
                    ))
            })
    ResponseEntity<EstudanteResponse> buscarEstudantePorId(
            @Parameter(in = PATH, required = true, description = "Id do estudante") String id);

    @Operation(summary = "Operação para atualizar estudante",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = EstudanteResponse.class)
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
                                                    name = "Estudante não encontrado",
                                                    value = "{\"messages\":[\"Estudante não encontrado\"]}")
                                    }
                    ))
            })
    ResponseEntity<EstudanteResponse> atualizarEstudante(
            @Parameter(in = PATH, required = true, description = "Id do estudante") String id,
            @RequestBody(required = true,
            content = @Content(schema = @Schema(
                    implementation = EstudanteRequest.class))) EstudanteRequest estudanteRequest);

    @Operation(summary = "Operação para deletar estudante",
            responses = {
                    @ApiResponse(
                            responseCode = "204",
                            description = "No Content",
                            content = @Content),
                    @ApiResponse(
                            responseCode = "403",
                            description = "Forbidden",
                            content = @Content)
            })
    ResponseEntity<Void> deletarEstudante(
            @Parameter(in = PATH, required = true, description = "Id do estudante") String id);

    @Operation(summary = "Operação para criar candidatura para estudante",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Created",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = EstudanteCandidatura.class)
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
                                            @ExampleObject(name = "Vaga não encontrada",
                                                    value = "{\"messages\":[\"Vaga com id [673ba6ad0974490d72b52ed9] não encontrada\"]}"),
                                            @ExampleObject(name = "Estudante não encontrado",
                                                    value = "{\"messages\":[\"Estudante com id [673ba6ad0974490d72b52ed9] não encontrado\"]}")
                                    }
                            ))
            })
    ResponseEntity<EstudanteCandidatura> criarCandidatura(
            @Parameter(in = PATH, required = true, description = "Id do estudante") String id,
            @Parameter(in = PATH, required = true, description = "Id da vaga") String idVaga);

    @Operation(summary = "Operação para deletar candidatura de estudante",
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
                            responseCode = "404",
                            description = "Not Found",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = {
                                            @ExampleObject(name = "Candidatura não encontrada",
                                                    value = "{\"messages\":[\"Candidatura com idVaga [673ba6ad0974490d72b52ed9] não encontrada para o estudante\"]}"),
                                            @ExampleObject(name = "Estudante não encontrado",
                                                    value = "{\"messages\":[\"Estudante com id [673ba6ad0974490d72b52ed9] não encontrado\"]}")
                                    }
                            )),
                    @ApiResponse(
                            responseCode = "409",
                            description = "Conflict",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = {
                                            @ExampleObject(name = "Estudante sem candidaturas",
                                                    value = "{\"messages\":[\"O estudante não possui candidaturas\"]}")
                                    }
                            ))
            })
    ResponseEntity<Void> deletarCandidatura(
            @Parameter(in = PATH, required = true, description = "Id do estudante") String id,
            @Parameter(in = PATH, required = true, description = "Id da vaga") String idVaga);
}
