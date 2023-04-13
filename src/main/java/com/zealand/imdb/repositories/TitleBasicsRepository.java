package com.zealand.imdb.repositories;

import com.zealand.imdb.models.TitleBasics;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TitleBasicsRepository extends JpaRepository<TitleBasics, String>, JpaSpecificationExecutor<TitleBasics> {
    Page<TitleBasics> findAll(Pageable pageable);
}