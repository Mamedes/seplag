package com.seletivo.infra.api.controller.pessoa;



import com.seletivo.infra.api.controller.pessoa.request.CreatePessoaRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "pessoa")
public interface PessoaAPI {

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(summary = "Create a new pessoa")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created successfully"),
            @ApiResponse(responseCode = "422", description = "A validation error was thrown"),
            @ApiResponse(responseCode = "500", description = "An internal server error was thrown"),
    })
    ResponseEntity<?> createPessoa(@RequestBody CreatePessoaRequest input);


    @GetMapping(
            value = "{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(summary = "Get a pessoa by it's identifier")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pessoa retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Pessoa was not found"),
            @ApiResponse(responseCode = "500", description = "An internal server error was thrown"),
    })
    PessoaResponse getById(@PathVariable(name = "id")  Long id);



}
