package com.zealand.imdb.repositories;

import com.zealand.imdb.models.views.MovieDetailsView;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieViewRepository extends JpaRepository<MovieDetailsView, String> {
}
