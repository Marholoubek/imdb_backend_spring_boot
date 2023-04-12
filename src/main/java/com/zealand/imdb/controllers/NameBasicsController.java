package com.zealand.imdb.controllers;

import com.zealand.imdb.models.NameBasics;
import com.zealand.imdb.services.NameBasicsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/actors")
public class NameBasicsController {

    final NameBasicsService nameBasicsService;

    @GetMapping
    public Page<NameBasics> getActors(@PageableDefault(size = 20) Pageable pageable,
                                      @RequestParam(value = "search", required = false) String searchTerm) {
        return nameBasicsService.getActors(pageable, searchTerm);
    }

    @GetMapping("/{id}")
    public NameBasics getActorById(@PathVariable String id) {
        return nameBasicsService.getActorById(id);
    }

}
