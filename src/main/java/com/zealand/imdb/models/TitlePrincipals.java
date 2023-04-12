package com.zealand.imdb.models;

import com.zealand.imdb.models.keys.TitlePrincipalCompositeKey;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "title_principals")
public class TitlePrincipals {

    @EmbeddedId
    TitlePrincipalCompositeKey id;

    @ManyToOne
    @JoinColumn(name = "tconst", insertable = false, updatable = false)
    private TitleBasics titleBasics;

    @ManyToOne
    @JoinColumn(name = "nconst", insertable = false, updatable = false)
    private NameBasics nameBasics;

    @ManyToOne
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    private PrincipalCategory principalCategory;

    @Column(name = "characters")
    private String characters;

    @Column(name = "job")
    private String job;

}
