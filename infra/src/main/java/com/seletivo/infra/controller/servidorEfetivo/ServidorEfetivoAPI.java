package com.seletivo.infra.controller.servidorEfetivo;

import com.seletivo.infra.controller.servidorEfetivo.request.CreateServidorEfetivoRequest;
import com.seletivo.infra.controller.servidorEfetivo.response.ServidorEfetivoResponse;
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



}
