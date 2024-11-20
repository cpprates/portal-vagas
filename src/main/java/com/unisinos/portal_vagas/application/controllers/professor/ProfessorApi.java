package com.unisinos.portal_vagas.application.controllers.professor;

import com.unisinos.portal_vagas.domain.data.model.professor.ProfessorRequest;
import com.unisinos.portal_vagas.domain.data.model.professor.ProfessorRequestFilter;
import com.unisinos.portal_vagas.domain.data.model.professor.ProfessorResponse;
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

public interface ProfessorApi {

    @Operation(summary = "Operação para criar professor",
            responses = {
                @ApiResponse(
                        responseCode = "201",
                        description = "Created",
                        content = @Content(
                                mediaType = MediaType.APPLICATION_JSON_VALUE,
                                schema = @Schema(implementation = ProfessorResponse.class)
                        ))
            })
    ResponseEntity<ProfessorResponse> criarProfessor(
            @RequestBody(
                    required = true,
                    content = @Content(schema = @Schema(
                            implementation = ProfessorRequest.class))) ProfessorRequest professorRequest);

    @Operation(summary = "Operação para buscar professores por filtro",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK",
                            content = @Content(
                                    array = @ArraySchema(schema = @Schema(implementation = ProfessorResponse[].class))
                            )),
                    @ApiResponse(
                            responseCode = "403",
                            description = "Forbidden",
                            content = @Content)
            })
    ResponseEntity<List<ProfessorResponse>> listarProfessores(
            @Parameter(in = QUERY, content = @Content(schema = @Schema(
                    implementation = ProfessorRequestFilter.class))) ProfessorRequestFilter professorRequestFilter);

    @Operation(summary = "Operação para buscar professor por id",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ProfessorResponse.class)
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
    ResponseEntity<ProfessorResponse> buscarProfessorPorId(
            @Parameter(in = PATH, required = true, description = "Id do professor") String id);

    @Operation(summary = "Operação para atualizar professor",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ProfessorResponse.class)
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
    ResponseEntity<ProfessorResponse> atualizarProfessor(
            @Parameter(in = PATH, required = true, description = "Id do professor") String id,
            @RequestBody(required = true,
            content = @Content(schema = @Schema(
                    implementation = ProfessorRequest.class))) ProfessorRequest professorRequest);

    @Operation(summary = "Operação para deletar professor",
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
    ResponseEntity<Void> deletarProfessor(
            @Parameter(in = PATH, required = true, description = "Id do professor") String id);
}
