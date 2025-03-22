package com.seletivo.infra.api.controller.fotoPessoa;

import com.seletivo.application.arquivo.ArquivoDTO;
import com.seletivo.application.pessoaFoto.CreateFotoPessoaCommand;
import com.seletivo.application.pessoaFoto.CreateFotoPessoaOutput;
import com.seletivo.application.pessoaFoto.CreatePessoaFotoUseCase;
import com.seletivo.application.pessoaFoto.fetch.GetPessoaFotoByIdUseCase;
import com.seletivo.application.pessoaFoto.list.ListPessoaFotoUseCase;
import com.seletivo.domain.pagination.Pagination;
import com.seletivo.domain.pagination.SearchQuery;
import com.seletivo.domain.validation.handler.Notification;
import com.seletivo.infra.api.controller.fotoPessoa.presenters.FotoPessoaApiPresenter;
import com.seletivo.infra.api.controller.fotoPessoa.request.CreateFotoPessoaRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
public class FotoPessoaController implements FotoPessoaAPI {

    private final CreatePessoaFotoUseCase createFotoPessoaUseCase;
    private  final ListPessoaFotoUseCase listPessoaFotoUseCase;
    private  final GetPessoaFotoByIdUseCase getPessoaFotoByIdUseCase;
    private final FotoPessoaApiPresenter fotoPessoaApiPresenter;


    public FotoPessoaController(final CreatePessoaFotoUseCase createFotoPessoaUseCase, final ListPessoaFotoUseCase listPessoaFotoUseCase,  final GetPessoaFotoByIdUseCase getPessoaFotoByIdUseCase, FotoPessoaApiPresenter fotoPessoaApiPresenter) {
        this.createFotoPessoaUseCase = Objects.requireNonNull(createFotoPessoaUseCase);
        this.listPessoaFotoUseCase = Objects.requireNonNull(listPessoaFotoUseCase);
        this.getPessoaFotoByIdUseCase = Objects.requireNonNull(getPessoaFotoByIdUseCase);
        this.fotoPessoaApiPresenter = fotoPessoaApiPresenter;


    }

    public ResponseEntity<?> createPessoa(final CreateFotoPessoaRequest input) {
        final List<ArquivoDTO> arquivosDTO = new ArrayList<>();
        for (MultipartFile file : input.files()) {
            try {
                arquivosDTO.add(new ArquivoDTO(file.getBytes(), file.getOriginalFilename(), file.getContentType()));
            } catch (IOException e) {
                return ResponseEntity.status(500).body("Erro ao ler o arquivo: " + e.getMessage());
            }
        }

        final var aCommand = CreateFotoPessoaCommand.with(input.pessoaID(), arquivosDTO);

        final Function<Notification, ResponseEntity<?>> onError = notification -> ResponseEntity.unprocessableEntity().body(notification);

        final Function<List<CreateFotoPessoaOutput>, ResponseEntity<?>> onSuccess = outputs -> {
            List<Long> ids = outputs.stream().map(CreateFotoPessoaOutput::id).collect(Collectors.toList());
            return ResponseEntity.created(java.net.URI.create("/foto-pessoa/" + ids.get(0))).body(outputs);
        };

        return this.createFotoPessoaUseCase.execute(aCommand).fold(onError, onSuccess);
    }

    @Override
    public FotoPessoaResponse getById(Long id) {
        return this.fotoPessoaApiPresenter.present(this.getPessoaFotoByIdUseCase.execute(id));
    }

    @Override
    public Pagination<FotoPessoaResponse> listFotos(
            final String search,
            final int page,
            final int perPage,
            final String sort,
            final String direction
    ) {
        return listPessoaFotoUseCase.execute(new SearchQuery(page, perPage, search, sort, direction))
                .map(fotoPessoaApiPresenter::present);
    }
}
