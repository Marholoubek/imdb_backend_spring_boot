package com.zealand.imdb.services;

import com.zealand.imdb.models.TitleBasics;
import com.zealand.imdb.repositories.TitleBasicsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TitleBasicsService {

    static private final Integer MAX_MOVIES = 50;

    final TitleBasicsRepository titleBasicsRepository;

    public TitleBasicsService(TitleBasicsRepository titleBasicsRepository) {
        this.titleBasicsRepository = titleBasicsRepository;
    }

    public Page<TitleBasics> getMovies(Pageable pageable) {
        return titleBasicsRepository.findAll(pageable);
    }
}
