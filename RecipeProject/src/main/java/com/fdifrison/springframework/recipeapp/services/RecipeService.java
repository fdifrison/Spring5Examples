package com.fdifrison.springframework.recipeapp.services;

import com.fdifrison.springframework.recipeapp.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.Set;


public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long id);
}
