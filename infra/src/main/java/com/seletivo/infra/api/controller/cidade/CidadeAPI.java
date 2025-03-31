package com.seletivo.infra.api.controller.cidade;

import com.seletivo.domain.pagination.Pagination;
import com.seletivo.infra.api.controller.cidade.request.CreateCidadeRequest;
import com.seletivo.infra.api.controller.cidade.request.UpdateCidadeRequest;
import com.seletivo.infra.api.controller.cidade.response.CidadeListResponse;
import com.seletivo.infra.api.controller.cidade.response.CidadeResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "cidade")
public interface CidadeAPI {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Create a new cidade")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created successfully"),
            @ApiResponse(responseCode = "422", description = "A validation error was thrown"),
            @ApiResponse(responseCode = "500", description = "An internal server error was thrown"),})
    ResponseEntity<?> createCidade(@RequestBody CreateCidadeRequest input);


    @GetMapping
    @Operation(summary = "List all cidades paginated")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listed successfully"),
            @ApiResponse(responseCode = "422", description = "A invalid parameter was received"),
            @ApiResponse(responseCode = "500", description = "An internal server error was thrown"),
    })
    Pagination<CidadeListResponse> listCidades(
            @RequestParam(name = "search", required = false, defaultValue = "") final String search,
            @RequestParam(name = "page", required = false, defaultValue = "0") final int page,
            @RequestParam(name = "perPage", required = false, defaultValue = "10") final int perPage,
            @RequestParam(name = "sort", required = false, defaultValue = "nome") final String sort,
            @RequestParam(name = "dir", required = false, defaultValue = "asc") final String direction
    );
    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get a cidade by it's identifier")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cidade retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Cidade was not found"),
            @ApiResponse(responseCode = "500", description = "An internal server error was thrown"),})
    CidadeResponse getById(@PathVariable(name = "id") Long id);

    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a cidade by it's identifier")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Cidade deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Cidade was not found"),
            @ApiResponse(responseCode = "500", description = "An internal server error was thrown"),})
    void deleteById(@PathVariable(name = "id") Long id);

    @PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Update a cidade by it's identifier")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cidade updated successfully"),
            @ApiResponse(responseCode = "404", description = "Cidade was not found"),
            @ApiResponse(responseCode = "500", description = "An internal server error was thrown"),})
    ResponseEntity<?> updateCidade(@PathVariable(name = "id") Long id,
                                   @RequestBody UpdateCidadeRequest input);
}
