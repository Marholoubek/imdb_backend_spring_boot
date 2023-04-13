package com.zealand.imdb.models.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@AllArgsConstructor
@Data
public class TitleBasicsApi {

    @NonNull
    private String titleType;

    @NonNull
    private String primaryTitle;

    @NonNull
    private String originalTitle;

    @NonNull
    private Boolean isAdult;

    @NonNull
    private Integer startYear;

    private Integer endYear;

    @NonNull
    private Integer runtimeMinutes;

    private List<String> genres;
}
