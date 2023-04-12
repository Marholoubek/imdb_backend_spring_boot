package com.zealand.imdb.repositories;

import com.zealand.imdb.models.Genres;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenresRepository extends JpaRepository<Genres, Integer> {
}
