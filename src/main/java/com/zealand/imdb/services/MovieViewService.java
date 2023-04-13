package com.zealand.imdb.services;

import com.zealand.imdb.models.views.MovieDetailsView;
import com.zealand.imdb.repositories.MovieViewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieViewService {

    final MovieViewRepository movieViewRepository;

    public MovieDetailsView getMovieDetails(String id) {
        return movieViewRepository.findById(id).orElse(null);
    }
}
