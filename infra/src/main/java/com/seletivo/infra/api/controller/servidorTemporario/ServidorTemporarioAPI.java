package com.seletivo.infra.api.controller.servidorTemporario;

import com.seletivo.infra.api.controller.servidorTemporario.request.CreateServidorTemporarioRequest;
import com.seletivo.infra.api.controller.servidorTemporario.request.UpdateServidorTemporarioRequest;
import com.seletivo.infra.api.controller.servidorTemporario.response.ServidorTemporarioResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "servidor-temporario")
@Tag(name = "2. Servidor Temorario", description = "Gerenciamento")
public interface ServidorTemporarioAPI {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    @Operation(
            summary = "Criar um novo Servidor Temporario",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CreateServidorTemporarioRequest.class),
                            examples = @ExampleObject(
                                    name = "Exemplo",
                                    value = """
                                            {
                                              "matricula": "123456",
                                              "pessoa": {
                                                "nome": "João Silva",
                                                "dataNascimento": "2025-03-31",
                                                "sexo": "Masculino",
                                                "nomeMae": "Maria da Silva",
                                                "nomePai": "José da Silva"
                                              }
                                            }
                                            """
                            )
                    )
            )
    )

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created successfully"),
            @ApiResponse(responseCode = "422",
                    description = "A validation error was thrown"),
            @ApiResponse(responseCode = "500",
                    description = "An internal server error was thrown"),})
    ResponseEntity<?> createServidorTemporario(
            @RequestBody CreateServidorTemporarioRequest input);


    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get a servidorTemporario by it's identifier")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "ServidorTemporario retrieved successfully"),
            @ApiResponse(responseCode = "404",
                    description = "ServidorTemporario was not found"),
            @ApiResponse(responseCode = "500",
                    description = "An internal server error was thrown"),})
    ServidorTemporarioResponse getById(@PathVariable(name = "id") Long id);

    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a Servidor Temporario by it's identifier")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    description = "Endereco Servidor Temporario successfully"),
            @ApiResponse(responseCode = "404", description = "Servidor Temporario was not found"),
            @ApiResponse(responseCode = "500",
                    description = "An internal server error was thrown"),})
    void deleteById(@PathVariable(name = "id") Long id);

    @PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Update a Servidor Temporario by it's identifier")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated successfully"),
            @ApiResponse(responseCode = "404", description = "Servidor Temporario was not found"),
            @ApiResponse(responseCode = "422", description = "A validation error was thrown"),
            @ApiResponse(responseCode = "500", description = "An internal server error was thrown"),
    })
    ResponseEntity<?> updateServidorTemporario(@PathVariable(name = "id") Long id, @RequestBody UpdateServidorTemporarioRequest input);

}