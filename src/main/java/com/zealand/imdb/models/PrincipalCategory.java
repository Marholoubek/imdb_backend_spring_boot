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
@Table(name = "principal_category")
public class PrincipalCategory {

    @Id
    @SequenceGenerator(name = "principal_category_id_seq", sequenceName = "principal_category_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "principal_category_id_seq")
    @Column(name = "principal_category_id")
    private Integer id;

    @Column(name = "name", unique = true)
    @NonNull
    private String name;
}
