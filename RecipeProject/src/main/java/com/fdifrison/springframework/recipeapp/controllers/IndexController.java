package com.fdifrison.springframework.recipeapp.controllers;

import com.fdifrison.springframework.recipeapp.model.Category;
import com.fdifrison.springframework.recipeapp.model.UnitOfMeasure;
import com.fdifrison.springframework.recipeapp.repositories.CategoryRepository;
import com.fdifrison.springframework.recipeapp.repositories.UnitOfMeasureRepository;
import com.fdifrison.springframework.recipeapp.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    @Autowired
    private RecipeService recipeService;

    @RequestMapping({"","/","/index"})
    public String getIndexPage(Model model) {

        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }
}
