package com.zealand.imdb.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "title_basics")
public class TitleBasics {

    @Id
    @Column(name = "tconst")
    private String tconst;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "title_type_id")
    private TitleTypes titleType;

    @Column(name = "primary_title")
    @NonNull
    private String primaryTitle;

    @Column(name = "original_title")
    @NonNull
    private String originalTitle;

    @Column(name = "is_adult")
    @NonNull
    private Boolean isAdult;

    @Column(name = "start_year")
    @NonNull
    private Integer startYear;

    @Column(name = "end_year")
    private Integer endYear;

    @Column(name = "runtime_minutes")
    @NonNull
    private Integer runtimeMinutes;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "title_genres",
            joinColumns = @JoinColumn(name = "tconst"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genres> genres;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "title_directors",
            joinColumns = @JoinColumn(name = "tconst"),
            inverseJoinColumns = @JoinColumn(name = "nconst"))
    private List<NameBasics> directors;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "title_writers",
            joinColumns = @JoinColumn(name = "tconst"),
            inverseJoinColumns = @JoinColumn(name = "nconst"))
    private List<NameBasics> writers;

}
