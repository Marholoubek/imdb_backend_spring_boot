package com.zealand.imdb.repositories;

import com.zealand.imdb.models.NameBasics;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface NameBasicsRepository extends JpaRepository<NameBasics, String>, JpaSpecificationExecutor<NameBasics> {
    Page<NameBasics> findAll(Pageable pageable);
}
