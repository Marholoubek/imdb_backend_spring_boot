package com.zealand.imdb.models.views;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Immutable
@Entity
@Subselect("SELECT * FROM V_MOVIE_DETAILS")
public class MovieDetailsView {

    @Id
    @Column(name = "tconst")
    private String tconst;

    @Column(name = "primary_title")
    private String primaryTitle;

    @Column(name = "original_title")
    private String originalTitle;

    @Column(name = "is_adult")
    private Boolean isAdult;

    @Column(name = "start_year")
    private Integer startYear;

    @Column(name = "end_year")
    private Integer endYear;

    @Column(name = "runtime_minutes")
    private Integer runtimeMinutes;

    @Column(name = "title_type")
    private String titleType;

    @Column(name = "genres")
    private String genres;

    @Column(name = "directors")
    private String directors;

    @Column(name = "writers")
    private String writers;
}
