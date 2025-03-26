package com.seletivo.infra.api.controller.lotacao;


import com.seletivo.infra.api.controller.lotacao.request.CreateLotacaoRequest;
import com.seletivo.infra.api.controller.lotacao.request.LotacaoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "lotacao")
public interface LotacaoAPI {

        @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
                        produces = MediaType.APPLICATION_JSON_VALUE)
        @Operation(summary = "Create a new lotacao")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "201", description = "Created successfully"),
                        @ApiResponse(responseCode = "422",
                                        description = "A validation error was thrown"),
                        @ApiResponse(responseCode = "500",
                                        description = "An internal server error was thrown"),})
        ResponseEntity<?> createLotacao(@RequestBody CreateLotacaoRequest input);


        @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
        @Operation(summary = "Get a lotacao by it's identifier")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200",
                                        description = "Lotacao retrieved successfully"),
                        @ApiResponse(responseCode = "404", description = "Lotacao was not found"),
                        @ApiResponse(responseCode = "500",
                                        description = "An internal server error was thrown"),})
        LotacaoResponse getById(@PathVariable(name = "id") Long id);

        // @PutMapping(
        // value = "{id}",
        // consumes = MediaType.APPLICATION_JSON_VALUE,
        // produces = MediaType.APPLICATION_JSON_VALUE
        // )
        // @Operation(summary = "Update a lotacao by it's identifier")
        // @ApiResponses(value = {
        // @ApiResponse(responseCode = "200", description = "Lotacao updated successfully"),
        // @ApiResponse(responseCode = "404", description = "Lotacao was not found"),
        // @ApiResponse(responseCode = "500", description = "An internal server error was thrown"),
        // })
        // ResponseEntity<?> updateById(@PathVariable(name = "id") Long id, @RequestBody
        // UpdateLotacaoRequest input);


        @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
        @ResponseStatus(HttpStatus.NO_CONTENT)
        @Operation(summary = "Delete a lotacao by it's identifier")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "204",
                                        description = "Unidade lotacao successfully"),
                        @ApiResponse(responseCode = "404", description = "lotacao was not found"),
                        @ApiResponse(responseCode = "500",
                                        description = "An internal server error was thrown"),})
        void deleteById(@PathVariable(name = "id") Long id);



}
