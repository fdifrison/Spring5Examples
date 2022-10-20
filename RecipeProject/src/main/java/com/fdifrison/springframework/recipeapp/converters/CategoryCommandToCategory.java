package com.fdifrison.springframework.recipeapp.converters;


import com.fdifrison.springframework.recipeapp.commands.CategoryCommand;
import com.fdifrison.springframework.recipeapp.model.Category;
import lombok.Synchronized;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 6/21/17.
 */
@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category>{

    @Synchronized
    @Nullable
    @Override
    public Category convert(@NotNull CategoryCommand source) {

        final Category category = new Category();
        category.setId(source.getId());
        category.setDescription(source.getDescription());
        return category;
    }
}
