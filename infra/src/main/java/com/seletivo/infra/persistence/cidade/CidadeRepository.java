package com.seletivo.infra.persistence.cidade;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CidadeRepository extends JpaRepository<CidadeJpaEntity, Long> {

    Page<CidadeJpaEntity> findAll(Specification<CidadeJpaEntity> whereClause, Pageable page);

    @Query(value = "select c.id from Cidade c where c.id in :ids")
    List<Long> existsByIds(@Param("ids") List<Long> ids);
}