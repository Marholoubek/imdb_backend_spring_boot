package com.zealand.imdb.configuration;

import com.zealand.imdb.models.NameBasics;
import org.springframework.data.jpa.domain.Specification;

public class NameBasicsSpecification {

    public static Specification<NameBasics> primaryNameContainsIgnoreCase(String searchTerm) {
        return (root, query, criteriaBuilder) -> {
            if (searchTerm == null || searchTerm.isEmpty()) {
                return null;
            }
            String searchTermPattern = "%" + searchTerm.toLowerCase() + "%";
            return criteriaBuilder.or(
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("primaryName")), searchTermPattern)
            );
        };
    }
}
