package com.seletivo.application.pessoaFoto.create;

import com.seletivo.application.arquivo.ArquivoDTO;

import java.util.List;

public record CreateFotoPessoaCommand(Long pessoaID, List<ArquivoDTO> arquivos) {

        public static CreateFotoPessoaCommand with(final Long pessoaID,
                        final List<ArquivoDTO> arquivos) {
                return new CreateFotoPessoaCommand(pessoaID, arquivos);
        }
}
