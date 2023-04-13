package com.zealand.imdb.services;

import com.zealand.imdb.configuration.TitleBasicsSpecification;
import com.zealand.imdb.models.Genres;
import com.zealand.imdb.models.TitleBasics;
import com.zealand.imdb.models.TitleTypes;
import com.zealand.imdb.models.api.TitleBasicsApi;
import com.zealand.imdb.repositories.GenresRepository;
import com.zealand.imdb.repositories.TitleBasicsRepository;
import com.zealand.imdb.repositories.TitleTypesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class TitleBasicsService {

    final TitleBasicsRepository titleBasicsRepository;

    final TitleTypesRepository titleTypesRepository;

    final GenresRepository genresRepository;


    public Page<TitleBasics> getMovies(Pageable pageable, String searchTerm) {
        Specification<TitleBasics> spec = TitleBasicsSpecification.titleOrDescriptionContainsIgnoreCase(searchTerm);
        return titleBasicsRepository.findAll(spec, pageable);
    }

    public TitleBasics getMovieById(String id) {
        return titleBasicsRepository.findById(id).orElse(null);
    }

    public TitleBasics createMovie(TitleBasicsApi titleBasicsApi) {
        TitleBasics titleBasics = new TitleBasics();
        mapToTitleBasics(titleBasicsApi, titleBasics);

        String id = titleBasics.getPrimaryTitle().toLowerCase().replace(" ", "_").replace(".", "");
        titleBasics.setTconst(id);
        return titleBasicsRepository.save(titleBasics);
    }

    public TitleBasics updateMovie(String id, TitleBasicsApi titleBasicsApi) {
        TitleBasics titleBasics = titleBasicsRepository.findById(id).orElse(null);
        if (titleBasics == null) {
            return null;
        }
        mapToTitleBasics(titleBasicsApi, titleBasics);

        return titleBasicsRepository.save(titleBasics);
    }

    private void mapToTitleBasics(TitleBasicsApi titleBasicsApi, TitleBasics titleBasics) {
        titleBasics.setPrimaryTitle(titleBasicsApi.getPrimaryTitle());
        titleBasics.setOriginalTitle(titleBasicsApi.getOriginalTitle());
        titleBasics.setIsAdult(titleBasicsApi.getIsAdult());
        titleBasics.setStartYear(titleBasicsApi.getStartYear());
        titleBasics.setEndYear(titleBasicsApi.getEndYear());
        titleBasics.setRuntimeMinutes(titleBasicsApi.getRuntimeMinutes());

        TitleTypes titleType = titleTypesRepository.findByName(titleBasicsApi.getTitleType());
        if (titleType == null) {
            titleType = new TitleTypes();
            titleType.setName(titleBasicsApi.getTitleType());
            titleType = titleTypesRepository.save(titleType);
        }

        titleBasics.setTitleType(titleType);
        List<Genres> genres = new ArrayList<>();
        titleBasicsApi.getGenres().forEach(genre -> {
            Genres genreEntity = genresRepository.findByName(genre);
            if (genreEntity == null) {
                genreEntity = new Genres();
                genreEntity.setName(genre);
                genreEntity = genresRepository.save(genreEntity);
            }
            genres.add(genreEntity);
        });
        titleBasics.setWriters(new ArrayList<>());
        titleBasics.setDirectors(new ArrayList<>());
        titleBasics.setGenres(genres);
    }


}
