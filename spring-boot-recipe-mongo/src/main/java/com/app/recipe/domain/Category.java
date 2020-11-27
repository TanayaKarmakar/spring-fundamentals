package com.app.recipe.domain;

import java.util.Set;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by jt on 6/13/17.
 */
@Getter
@Setter
@Document
public class Category {
    private String id;
    private String description;
    private Set<Recipe> recipes;
}
