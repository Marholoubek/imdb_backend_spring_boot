package com.zealand.imdb.controllers;

import com.zealand.imdb.models.TitleBasics;
import com.zealand.imdb.models.api.TitleBasicsApi;
import com.zealand.imdb.services.TitleBasicsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/titles")
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

    @PostMapping
    public TitleBasics createMovie(@RequestBody TitleBasicsApi titleBasics) {
        return titleBasicsService.createMovie(titleBasics);
    }

    @PutMapping("/{id}")
    public TitleBasics updateMovie(@PathVariable String id, @RequestBody TitleBasicsApi titleBasics) {
        return titleBasicsService.updateMovie(id, titleBasics);
    }

}
