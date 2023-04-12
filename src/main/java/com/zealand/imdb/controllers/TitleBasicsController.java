package com.zealand.imdb.controllers;

import com.zealand.imdb.models.TitleBasics;
import com.zealand.imdb.services.TitleBasicsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TitleBasicsController {

    final TitleBasicsService titleBasicsService;

    public TitleBasicsController(TitleBasicsService titleBasicsService) {
        this.titleBasicsService = titleBasicsService;
    }

    @GetMapping("/movies")
    public Page<TitleBasics> getMovies(@PageableDefault(size = 20) Pageable pageable) {
        return titleBasicsService.getMovies(pageable);
    }
}
