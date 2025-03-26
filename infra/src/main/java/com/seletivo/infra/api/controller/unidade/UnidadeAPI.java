package com.seletivo.infra.api.controller.unidade;

import com.seletivo.domain.pagination.Pagination;
import com.seletivo.infra.api.controller.unidade.response.UnidadeListResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.seletivo.infra.api.controller.unidade.request.CreateUnidadeRequest;
import com.seletivo.infra.api.controller.unidade.response.UnidadeResponse;
import com.seletivo.infra.api.controller.unidade.request.UpdateUnidadeRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RequestMapping(value = "unidade")
public interface UnidadeAPI {

        @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
                        produces = MediaType.APPLICATION_JSON_VALUE)
        @Operation(summary = "Create a new unidade")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "201", description = "Created successfully"),
                        @ApiResponse(responseCode = "422",
                                        description = "A validation error was thrown"),
                        @ApiResponse(responseCode = "500",
                                        description = "An internal server error was thrown"),})
        ResponseEntity<?> createUnidade(@RequestBody CreateUnidadeRequest input);

        @GetMapping
        @Operation(summary = "List all categories paginated")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Listed successfully"),
                @ApiResponse(responseCode = "422", description = "A invalid parameter was received"),
                @ApiResponse(responseCode = "500", description = "An internal server error was thrown"),
        })
        Pagination<UnidadeListResponse> listUnidades(
                @RequestParam(name = "search", required = false, defaultValue = "") final String search,
                @RequestParam(name = "page", required = false, defaultValue = "0") final int page,
                @RequestParam(name = "perPage", required = false, defaultValue = "10") final int perPage,
                @RequestParam(name = "sort", required = false, defaultValue = "nome") final String sort,
                @RequestParam(name = "dir", required = false, defaultValue = "asc") final String direction
        );

        @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
        @Operation(summary = "Get a unidade by it's identifier")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200",
                                        description = "Unidade retrieved successfully"),
                        @ApiResponse(responseCode = "404", description = "Unidade was not found"),
                        @ApiResponse(responseCode = "500",
                                        description = "An internal server error was thrown"),})
        UnidadeResponse getById(@PathVariable(name = "id") Long id);

        @PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
                        produces = MediaType.APPLICATION_JSON_VALUE)
        @Operation(summary = "Update a unidade by it's identifier")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200",
                                        description = "Unidade updated successfully"),
                        @ApiResponse(responseCode = "404", description = "Unidade was not found"),
                        @ApiResponse(responseCode = "500",
                                        description = "An internal server error was thrown"),})
        ResponseEntity<?> updateById(@PathVariable(name = "id") Long id,
                        @RequestBody UpdateUnidadeRequest input);


        @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
        @ResponseStatus(HttpStatus.NO_CONTENT)
        @Operation(summary = "Delete a unidade by it's identifier")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "204",
                                        description = "Unidade deleted successfully"),
                        @ApiResponse(responseCode = "404", description = "Unidade was not found"),
                        @ApiResponse(responseCode = "500",
                                        description = "An internal server error was thrown"),})
        void deleteById(@PathVariable(name = "id") Long id);

}
