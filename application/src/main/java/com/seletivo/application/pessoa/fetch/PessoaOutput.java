package com.seletivo.application.pessoa.fetch;



import com.seletivo.domain.pessoa.Pessoa;
import com.seletivo.domain.pessoa.PessoaID;

import java.time.LocalDate;

public record PessoaOutput(
        PessoaID id,
        String nome,
        LocalDate dataNascimento,
        String sexo,
        String nomeMae,
        String nomePai
) {

    public static PessoaOutput from(final Pessoa aPessoa) {
        return new PessoaOutput(
                aPessoa.getId(),
                aPessoa.getNome(),
                aPessoa.getDataNascimento(),
                aPessoa.getSexo(),
                aPessoa.getNomeMae(),
                aPessoa.getNomePai()
        );
    }
}