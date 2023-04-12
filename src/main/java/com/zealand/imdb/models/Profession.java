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
@Table(name = "professions")
public class Profession {

    @Id
    @SequenceGenerator(name = "professions_id_seq", sequenceName = "professions_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "professions_id_seq")
    @Column(name = "profession_id")
    private Integer id;

    @Column(name = "name", unique = true)
    @NonNull
    private String name;
}
