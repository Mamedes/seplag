package com.seletivo.domain.pessoa;


import com.seletivo.domain.AggregateRoot;
import com.seletivo.domain.validation.ValidationHandler;


import java.time.LocalDate;

public class Pessoa extends AggregateRoot<PessoaID> implements Cloneable {
    private final String nome;
    private final LocalDate dataNascimento;
    private final String sexo;
    private final String nomeMae;
    private final String nomePai;

    public Pessoa(final PessoaID pessoaID, final String nome, final LocalDate dataNascimento, final String sexo, final String nomeMae, final String nomePai) {
        super(pessoaID);
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.nomeMae = nomeMae;
        this.nomePai = nomePai;
    }

    public static Pessoa newPessoa(final String nome, final LocalDate dataNascimento, final String sexo, final String nomeMae, final String nomePai) {

        return new Pessoa(null, nome, dataNascimento, sexo, nomeMae, nomePai);
    }

    public static Pessoa with(
            final PessoaID anId,
             final String nome,
     final LocalDate dataNascimento,
     final String sexo,
     final String nomeMae,
     final String nomePai
    ) {
        return new Pessoa(
                anId,
                nome,
                dataNascimento,
                sexo,
                nomeMae,
                nomePai
        );
    }

    public static Pessoa with(final Pessoa aPessoa) {
        return with(
                aPessoa.getId(),
                aPessoa.nome,
                aPessoa.dataNascimento,
                aPessoa.sexo,
                aPessoa.nomeMae,
                aPessoa.nomePai
        );
    }

    @Override
    public void validate(final ValidationHandler handler) {
        new PessoaValidator(this, handler).validate();
    }

    public PessoaID getId() {
        return id;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public String getSexo() {
        return sexo;
    }
}