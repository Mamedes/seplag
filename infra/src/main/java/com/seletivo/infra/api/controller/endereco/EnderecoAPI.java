package com.seletivo.infra.api.controller.endereco;

import com.seletivo.infra.api.controller.endereco.request.CreateEnderecoRequest;
import com.seletivo.infra.api.controller.endereco.request.EnderecoResponse;
import com.seletivo.infra.api.controller.endereco.request.UpdateEnderecoRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "endereco")
public interface EnderecoAPI {

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(summary = "Create a new endereco")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created successfully"),
            @ApiResponse(responseCode = "422", description = "A validation error was thrown"),
            @ApiResponse(responseCode = "500", description = "An internal server error was thrown"),
    })
    ResponseEntity<?> createEndereco(@RequestBody CreateEnderecoRequest input);


    @GetMapping(
            value = "{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(summary = "Get a endereco by it's identifier")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Endereco retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Endereco was not found"),
            @ApiResponse(responseCode = "500", description = "An internal server error was thrown"),
    })
    EnderecoResponse getById(@PathVariable(name = "id")  Long id);

    @PutMapping(
            value = "{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(summary = "Update a endereco by it's identifier")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Endereco updated successfully"),
            @ApiResponse(responseCode = "404", description = "Endereco was not found"),
            @ApiResponse(responseCode = "500", description = "An internal server error was thrown"),
    })
    ResponseEntity<?> updateById(@PathVariable(name = "id") Long id, @RequestBody UpdateEnderecoRequest input);


    @DeleteMapping(
            value = "{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a endereco by it's identifier")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Endereco deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Endereco was not found"),
            @ApiResponse(responseCode = "500", description = "An internal server error was thrown"),
    })
    void deleteById(@PathVariable(name = "id") Long id);


}
