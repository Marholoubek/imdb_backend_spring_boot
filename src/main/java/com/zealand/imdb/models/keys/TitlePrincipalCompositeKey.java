package com.zealand.imdb.models.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.NonNull;

import java.io.Serializable;

@Embeddable
public class TitlePrincipalCompositeKey implements Serializable {

    @Column(name = "tconst")
    @NonNull
    private String tconst;

    @Column(name = "ordering")
    @NonNull
    private Integer ordering;

    @Column(name = "nconst")
    @NonNull
    private String nconst;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TitlePrincipalCompositeKey that = (TitlePrincipalCompositeKey) o;

        if (!tconst.equals(that.tconst)) return false;
        if (!ordering.equals(that.ordering)) return false;
        return nconst.equals(that.nconst);
    }

    @Override
    public int hashCode() {
        int result = tconst.hashCode();
        result = 31 * result + ordering.hashCode();
        result = 31 * result + nconst.hashCode();
        return result;
    }
}
