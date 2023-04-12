package com.zealand.imdb.configuration;

import com.zealand.imdb.models.TitleBasics;
import org.springframework.data.jpa.domain.Specification;

public class TitleBasicsSpecification {

    public static Specification<TitleBasics> titleOrDescriptionContainsIgnoreCase(String searchTerm) {
        return (root, query, criteriaBuilder) -> {
            if (searchTerm == null || searchTerm.isEmpty()) {
                return null;
            }
            String searchTermPattern = "%" + searchTerm.toLowerCase() + "%";
            return criteriaBuilder.or(
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("primaryTitle")), searchTermPattern),
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("originalTitle")), searchTermPattern)
            );
        };
    }
}
