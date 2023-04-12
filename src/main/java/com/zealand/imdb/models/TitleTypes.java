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
@Table(name = "title_types")
public class TitleTypes {

    @Id
    @SequenceGenerator(name = "title_types_id_seq", sequenceName = "title_types_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "title_types_id_seq")
    @Column(name = "title_type_id")
    private Integer id;

    @Column(name = "name", unique = true)
    @NonNull
    private String name;
}
