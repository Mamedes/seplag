package com.seletivo.infra.persistence.pessoa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FotoPessoaRepository extends JpaRepository<FotoPessoaJpaEntity, Long> {

    Page<FotoPessoaJpaEntity> findAll(Specification<FotoPessoaJpaEntity> whereClause, Pageable page);

}
