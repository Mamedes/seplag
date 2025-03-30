package com.seletivo.application.pessoaFoto.update;

import com.seletivo.application.arquivo.ArquivoDTO;

import java.util.List;

public record UpdateFotoPessoaCommand(Long id, Long pessoaID, List<ArquivoDTO> arquivos) {

    public static UpdateFotoPessoaCommand with(final Long id, final Long pessoaID, final List<ArquivoDTO> arquivos) {
        return new UpdateFotoPessoaCommand(id, pessoaID, arquivos);
    }
}