package com.seletivo.infra.persistence.pessoa;



import com.seletivo.domain.pessoa.Pessoa;
import com.seletivo.domain.pessoa.PessoaID;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "Pessoa")
@Table(name = "pessoa")
public class PessoaJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoa_seq")
    @SequenceGenerator(name = "pessoa_seq", sequenceName = "pessoa_id_seq", allocationSize = 1)
    @Column(name = "pes_id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "pes_nome", nullable = false)
    private String nome;

    @Column(name = "pes_data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "pes_sexo", nullable = false)
    private String sexo;

    @Column(name = "pes_mae", nullable = false)
    private String nomeMae;

    @Column(name = "pes_pai", nullable = false)
    private String nomePai;

    public PessoaJpaEntity() {
    }

    public PessoaJpaEntity(final Long id, final String nome, final LocalDate dataNascimento, final String sexo, final String nomeMae, final String nomePai) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.nomeMae = nomeMae;
        this.nomePai = nomePai;
    }

    public static PessoaJpaEntity from(final Pessoa aPessoa) {
        return new PessoaJpaEntity(
                aPessoa.getId() != null ? aPessoa.getId().getValue() : null,
                aPessoa.getNome(),
                aPessoa.getDataNascimento(),
                aPessoa.getSexo(),
                aPessoa.getNomeMae(),
                aPessoa.getNomePai()
        );
    }

    public Pessoa toAggregate() {
        return Pessoa.with(
                getId() != null ? PessoaID.from(getId()) : null,
                getNome(),
                getDataNascimento(),
                getSexo(),
                getNomeMae(),
                getNomePai()

        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }
}
