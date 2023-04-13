package com.zealand.imdb.services;

import com.zealand.imdb.configuration.NameBasicsSpecification;
import com.zealand.imdb.models.NameBasics;
import com.zealand.imdb.models.api.NameBasicsApi;
import com.zealand.imdb.repositories.NameBasicsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

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

    public NameBasics createActor(NameBasicsApi nameBasicsApi) {
        NameBasics nameBasics = new NameBasics();
        nameBasics.setPrimaryName(nameBasicsApi.getPrimaryName());
        nameBasics.setBirthYear(nameBasicsApi.getBirthYear());
        nameBasics.setDeathYear(nameBasicsApi.getDeathYear());
        String id = nameBasics.getPrimaryName().toLowerCase().replace(" ", "_").replace(".", "");
        nameBasics.setId(id);
        return nameBasicsRepository.save(nameBasics);
    }

    public NameBasics updateActor(String id, NameBasicsApi nameBasicsApi) {
        NameBasics nameBasics = nameBasicsRepository.findById(id).orElse(null);
        if (nameBasics != null) {
            nameBasics.setPrimaryName(nameBasicsApi.getPrimaryName());
            nameBasics.setBirthYear(nameBasicsApi.getBirthYear());
            nameBasics.setDeathYear(nameBasicsApi.getDeathYear());
            return nameBasicsRepository.save(nameBasics);
        }
        return null;
    }

    public void deleteActor(String id) {
        nameBasicsRepository.deleteById(id);
    }
}
