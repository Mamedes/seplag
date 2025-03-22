package com.seletivo.infra.api.controller.fotoPessoa.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public record CreateFotoPessoaRequest(
        @JsonProperty("pessoaID") Long pessoaID,
        @JsonProperty("files") List<MultipartFile> files

) {
}