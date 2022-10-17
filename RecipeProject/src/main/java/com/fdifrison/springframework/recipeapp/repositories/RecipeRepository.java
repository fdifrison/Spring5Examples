package com.fdifrison.springframework.recipeapp.repositories;

import com.fdifrison.springframework.recipeapp.model.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
