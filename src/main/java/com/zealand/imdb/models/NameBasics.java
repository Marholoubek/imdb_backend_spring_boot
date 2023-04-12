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
@Table(name = "name_basics")
public class NameBasics {

    @Id
    @Column(name = "nconst")
    private String id;

    @Column(name = "primary_name")
    @NonNull
    private String primaryName;

    @Column(name = "birth_year")
    @NonNull
    private Integer birthYear;

    @Column(name = "death_year")
    private Integer deathYear;

    @ManyToMany
    @JoinTable(
            name = "name_professions",
            joinColumns = @JoinColumn(name = "nconst"),
            inverseJoinColumns = @JoinColumn(name = "profession_id")
    )
    private List<Profession> professions;

    @ManyToMany
    @JoinTable(
            name = "name_known_for_titles",
            joinColumns = @JoinColumn(name = "nconst"),
            inverseJoinColumns = @JoinColumn(name = "tconst")
    )
    private List<TitleBasics> knownForTitles;
}
