package com.seletivo.infra.persistence.unidade;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UnidadeEnderecoRepository extends JpaRepository<UnidadeEnderecoJpaEntity, Long> {

    Page<UnidadeEnderecoJpaEntity> findAll(Specification<UnidadeEnderecoJpaEntity> whereClause, Pageable page);


}
