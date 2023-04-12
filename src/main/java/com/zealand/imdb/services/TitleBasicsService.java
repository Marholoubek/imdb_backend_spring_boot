package com.zealand.imdb.services;

import com.zealand.imdb.configuration.TitleBasicsSpecification;
import com.zealand.imdb.models.TitleBasics;
import com.zealand.imdb.repositories.TitleBasicsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class TitleBasicsService {

    final TitleBasicsRepository titleBasicsRepository;


    public Page<TitleBasics> getMovies(Pageable pageable, String searchTerm) {
        Specification<TitleBasics> spec = TitleBasicsSpecification.titleOrDescriptionContainsIgnoreCase(searchTerm);
        return titleBasicsRepository.findAll(spec, pageable);
    }

    public TitleBasics getMovieById(String id) {
        return titleBasicsRepository.findById(id).orElse(null);
    }
}
