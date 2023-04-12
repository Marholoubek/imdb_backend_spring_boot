package com.zealand.imdb.models;

import com.zealand.imdb.models.keys.TitleAkasCompositeKey;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "title_akas")
public class TitleAkas {

    @EmbeddedId
    private TitleAkasCompositeKey id;

    @ManyToOne
    @JoinColumn(name = "tconst", insertable = false, updatable = false)
    private TitleBasics titleBasics;

    @Column(name = "title")
    @NonNull
    private String title;

    @Column(name = "region")
    @NonNull
    private String region;

    @Column(name = "language")
    @NonNull
    private String language;

    @Column(name = "attributes")
    private String attributes;

    @Column(name = "is_original_title")
    @NonNull
    private Boolean isOriginalTitle;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "akas_type_id")
    private AkasType akasType;


}
