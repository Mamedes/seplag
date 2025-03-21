package com.seletivo.infra.persistence.servidorTemporario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServidorTemporarioRepository extends JpaRepository<ServidorTemporarioJpaEntity, Long> {

    Page<ServidorTemporarioJpaEntity> findAll(Specification<ServidorTemporarioJpaEntity> whereClause,
            Pageable page);

}
