package com.seletivo.infra.api.controller.servidorEfetivo;

import com.seletivo.domain.pagination.Pagination;
import com.seletivo.infra.api.controller.servidorEfetivo.request.CreateServidorEfetivoRequest;
import com.seletivo.infra.api.controller.servidorEfetivo.response.ServidorEfetivoByUnidadeResponse;
import com.seletivo.infra.api.controller.servidorEfetivo.response.ServidorEfetivoResponse;
import com.seletivo.infra.api.controller.servidorEfetivo.response.ServidorEnderecoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "servidor-efetivo")
public interface ServidorEfetivoAPI {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Create a new servidorEfetivo.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created successfully"),
            @ApiResponse(responseCode = "422",
                    description = "A validation error was thrown"),
            @ApiResponse(responseCode = "500",
                    description = "An internal server error was thrown"),})
    ResponseEntity<?> createServidorEfetivo(@RequestBody CreateServidorEfetivoRequest input);


    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get a servidorEfetivo. by it's identifier")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "ServidorEfetivo retrieved successfully"),
            @ApiResponse(responseCode = "404",
                    description = "ServidorEfetivo was not found"),
            @ApiResponse(responseCode = "500",
                    description = "An internal server error was thrown"),})
    ServidorEfetivoResponse getById(@PathVariable(name = "id") Long id);


    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Search servidor endereco by name with pagination.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Servidor endereco retrieved successfully"),
            @ApiResponse(responseCode = "422",
                    description = "A invalid parameter was received"),
            @ApiResponse(responseCode = "500",
                    description = "An internal server error was thrown"),})
    Pagination<ServidorEnderecoResponse> searchEnderecoByNome(
            @RequestParam(name = "nome", required = false, defaultValue = "") final String nome,
            @RequestParam(name = "page", required = false, defaultValue = "0") final int page,
            @RequestParam(name = "perPage", required = false, defaultValue = "10") final int perPage,
            @RequestParam(name = "sort", required = false, defaultValue = "nomeServidor") final String sort,
            @RequestParam(name = "dir", required = false, defaultValue = "asc") final String direction
    );

    @GetMapping(value = "/unidade/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Search servidor endereco by name with pagination.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Servidor endereco retrieved successfully"),
            @ApiResponse(responseCode = "422",
                    description = "A invalid parameter was received"),
            @ApiResponse(responseCode = "500",
                    description = "An internal server error was thrown"),})
    Pagination<ServidorEfetivoByUnidadeResponse> listServidoresByUnidade(@PathVariable(name = "id") Long id,
                                                                         @RequestParam(name = "nome", required = false, defaultValue = "") final String nome,
                                                                         @RequestParam(name = "page", required = false, defaultValue = "0") final int page,
                                                                         @RequestParam(name = "perPage", required = false, defaultValue = "10") final int perPage,
                                                                         @RequestParam(name = "sort", required = false, defaultValue = "nome") final String sort,
                                                                         @RequestParam(name = "dir", required = false, defaultValue = "asc") final String direction
    );
}