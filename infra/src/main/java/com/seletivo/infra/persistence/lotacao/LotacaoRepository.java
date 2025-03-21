package com.seletivo.infra.persistence.lotacao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LotacaoRepository extends JpaRepository<LotacaoJpaEntity, Long> {

    Page<LotacaoJpaEntity> findAll(Specification<LotacaoJpaEntity> whereClause, Pageable page);

}
