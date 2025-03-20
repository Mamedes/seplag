package com.seletivo.infra.persistence.endereco;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<EnderecoJpaEntity, Long> {

    Page<EnderecoJpaEntity> findAll(Specification<EnderecoJpaEntity> whereClause, Pageable page);

}
