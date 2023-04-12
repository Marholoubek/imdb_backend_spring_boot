package com.zealand.imdb.services;

import com.zealand.imdb.models.NameBasics;
import com.zealand.imdb.repositories.NameBasicsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import com.zealand.imdb.configuration.NameBasicsSpecification;

@Service
@RequiredArgsConstructor

public class NameBasicsService {

    final NameBasicsRepository nameBasicsRepository;

    public Page<NameBasics> getActors(Pageable pageable, String searchTerm) {
        Specification<NameBasics> spec = NameBasicsSpecification.primaryNameContainsIgnoreCase(searchTerm);
        return nameBasicsRepository.findAll(spec, pageable);
    }

    public NameBasics getActorById(String id) {
        return nameBasicsRepository.findById(id).orElse(null);
    }
}
