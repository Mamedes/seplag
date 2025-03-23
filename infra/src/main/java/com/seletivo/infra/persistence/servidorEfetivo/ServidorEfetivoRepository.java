package com.seletivo.infra.persistence.servidorEfetivo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ServidorEfetivoRepository extends JpaRepository<ServidorEfetivoJpaEntity, Long> {

    Page<ServidorEfetivoJpaEntity> findAll(Specification<ServidorEfetivoJpaEntity> whereClause,
            Pageable page);

    @Query(value = "SELECT p.pes_nome AS nomeServidor, u.unid_nome AS nomeUnidade, e.end_logradouro AS logradouro, e.end_numero AS numero, e.end_bairro AS bairro " +
            "FROM servidor_efetivo se " +
            "JOIN pessoa p ON se.pes_id = p.pes_id " +
            "JOIN lotacao l ON p.pes_id = l.pes_id " +
            "JOIN unidade u ON l.unid_id = u.unid_id " +
            "JOIN unidade_endereco ue ON u.unid_id = ue.unid_id " +
            "JOIN endereco e ON ue.end_id = e.end_id " +
            "WHERE p.pes_nome ILIKE %:nome%", nativeQuery = true)
    Page<ServidorEnderecoProjection> findServidorEnderecoByNome(@Param("nome") String nome, Pageable pageable);

    @Query(value = "SELECT p.pes_nome AS nome, p.pes_data_nascimento AS dataNascimento, u.unid_nome AS nomeUnidade,fp.fp_bucket AS bucketFoto " +
            "FROM servidor_efetivo se " +
            "JOIN pessoa p ON se.pes_id = p.pes_id " +
            "JOIN lotacao l ON p.pes_id = l.pes_id " +
            "JOIN unidade u ON l.unid_id = u.unid_id " +
            "LEFT JOIN foto_pessoa fp ON p.pes_id = fp.pes_id " +
            "WHERE u.unid_id = :unidadeId AND p.pes_nome ILIKE %:nome%", nativeQuery = true)
    Page<ServidorEfetivoByUnidadeProjection> findServidoresByUnidade(@Param("nome") String nome, @Param("unidadeId") Long unidadeId, Pageable pageable);
}