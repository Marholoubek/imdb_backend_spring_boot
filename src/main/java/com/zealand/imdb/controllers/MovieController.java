package com.zealand.imdb.controllers;

import com.zealand.imdb.models.views.MovieDetailsView;
import com.zealand.imdb.services.MovieViewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    final MovieViewService movieViewService;

    @GetMapping("/{id}")
    public MovieDetailsView getMovieDetails(@PathVariable String id) {
        return movieViewService.getMovieDetails(id);
    }
}
