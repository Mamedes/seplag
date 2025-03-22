package com.seletivo.infra.api.controller.unidade;

import com.seletivo.infra.api.controller.unidade.request.CreateUnidadeRequest;
import com.seletivo.infra.api.controller.unidade.request.UnidadeResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "unidade")
public interface UnidadeAPI {

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(summary = "Create a new unidade")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created successfully"),
            @ApiResponse(responseCode = "422", description = "A validation error was thrown"),
            @ApiResponse(responseCode = "500", description = "An internal server error was thrown"),
    })
    ResponseEntity<?> createUnidade(@RequestBody CreateUnidadeRequest input);


    @GetMapping(
            value = "{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(summary = "Get a unidade by it's identifier")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Unidade retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Unidade was not found"),
            @ApiResponse(responseCode = "500", description = "An internal server error was thrown"),
    })
    UnidadeResponse getById(@PathVariable(name = "id")  Long id);



}
