package com.fdifrison.springframework.recipeapp.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    Category category;


    @BeforeEach
    void setUp() {
       category = new Category();
    }

    @Test
    @DisplayName("Getting id from category")
    void getId() {
        Long id = 4L;
        category.setId(id);
        assertEquals(4L, category.getId());
    }

    @Test
    @DisplayName("Get description from category")
    void getDescription() {
        String description = "Italian";
        category.setDescription(description);
        assertEquals("Italian", category.getDescription());
    }

    @Test
    void getRecipes() {
        Set<Recipe> recipes = new HashSet<>();
        recipes.add(new Recipe());
        category.setRecipes(recipes);
        assertSame(recipes, category.getRecipes());
    }
}