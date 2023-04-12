package com.zealand.imdb.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "genres")
public class Genres {

    @Id
    @SequenceGenerator(name = "genres_id_seq", sequenceName = "genres_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genres_id_seq")
    @Column(name = "genre_id")
    private Integer id;

    @Column(name = "name", unique = true)
    @NonNull
    private String name;
}
