package com.fdifrison.springframework.recipeapp.services;

import com.fdifrison.springframework.recipeapp.model.Recipe;
import com.fdifrison.springframework.recipeapp.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;
    @Mock
    RecipeRepository recipeRepository;

    @BeforeEach
    void setUp()  throws  Exception {
        MockitoAnnotations.openMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);

    }

    @Test
    void getRecipes() throws Exception {
        Set<Recipe> recipes = recipeService.getRecipes();
        assertEquals(recipes.size(), 0);
    }
}