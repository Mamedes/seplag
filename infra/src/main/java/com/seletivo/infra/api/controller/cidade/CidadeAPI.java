package com.seletivo.infra.api.controller.cidade;

import com.seletivo.domain.pagination.Pagination;
import com.seletivo.infra.api.controller.cidade.response.CidadeListResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "cidade")
public interface CidadeAPI {

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
}
