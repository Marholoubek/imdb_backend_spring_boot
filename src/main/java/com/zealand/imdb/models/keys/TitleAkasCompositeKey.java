package com.zealand.imdb.models.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.NonNull;

import java.io.Serializable;

@Embeddable

public class TitleAkasCompositeKey implements Serializable {

    @Column(name = "tconst")
    @NonNull
    private String tconst;

    @Column(name = "ordering")
    @NonNull
    private Integer ordering;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TitleAkasCompositeKey that = (TitleAkasCompositeKey) o;

        if (!tconst.equals(that.tconst)) return false;
        return ordering.equals(that.ordering);
    }

    @Override
    public int hashCode() {
        int result = tconst.hashCode();
        result = 31 * result + ordering.hashCode();
        return result;
    }

}
