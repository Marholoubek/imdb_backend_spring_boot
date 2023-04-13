package com.zealand.imdb.models.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@AllArgsConstructor
@Data
public class NameBasicsApi {
    @NonNull
    private String primaryName;

    @NonNull
    private Integer birthYear;

    private Integer deathYear;
}
