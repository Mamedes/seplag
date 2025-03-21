package com.seletivo.infra.persistence.servidorEfetivo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServidorEfetivoRepository extends JpaRepository<ServidorEfetivoJpaEntity, Long> {

    Page<ServidorEfetivoJpaEntity> findAll(Specification<ServidorEfetivoJpaEntity> whereClause,
            Pageable page);

}
