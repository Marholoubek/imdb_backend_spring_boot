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
@Table(name = "akas_types")
public class AkasType {

    @Id
    @SequenceGenerator(name = "akas_types_id_seq", sequenceName = "akas_types_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "akas_types_id_seq")
    @Column(name = "akas_type_id")
    private Integer id;

    @Column(name = "name", unique = true)
    @NonNull
    private String name;

}
