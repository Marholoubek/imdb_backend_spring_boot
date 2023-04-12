package com.zealand.imdb.controllers;

import com.zealand.imdb.models.TitleBasics;
import com.zealand.imdb.services.TitleBasicsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/movies")
public class TitleBasicsController {

    final TitleBasicsService titleBasicsService;


    @GetMapping
    public Page<TitleBasics> getMovies(@PageableDefault(size = 20) Pageable pageable,
                                       @RequestParam(value = "search", required = false) String searchTerm) {
        return titleBasicsService.getMovies(pageable, searchTerm);
    }

    @GetMapping("/{id}")
    public TitleBasics getMovieById(@PathVariable String id) {
        return titleBasicsService.getMovieById(id);
    }
}
