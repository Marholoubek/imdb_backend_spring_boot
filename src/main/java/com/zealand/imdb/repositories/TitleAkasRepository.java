package com.zealand.imdb.repositories;

import com.zealand.imdb.models.TitleAkas;
import com.zealand.imdb.models.keys.TitleAkasCompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TitleAkasRepository extends JpaRepository<TitleAkas, TitleAkasCompositeKey> {
}