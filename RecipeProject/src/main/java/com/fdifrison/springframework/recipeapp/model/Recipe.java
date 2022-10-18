package com.fdifrison.springframework.recipeapp.model;

import lombok.*;
import org.hibernate.Hibernate;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    @Lob
    private String directions;

    /*
     mappedBy define the property upon which the child table is mapped to the parent table
     "recipe" is the target property in the Ingredients class
    */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    @ToString.Exclude
    private Set<Ingredient> ingredients = new HashSet<>();

    /*
     Lob: We are storing a Byte array for an image, so we
     are telling the db to expect something bigger than usual and prepare for a BLOB = Binary Large Object Field
    */
    @Lob
    private Byte[] image;

    // Cascade: every operation on a recipe object will be reflected also on the associated Notes object
    @OneToOne(cascade = CascadeType.ALL)

    private Notes notes;

    /*
     EnumType specify how the enum are stored in the db. Default value is ORDINAL, meaning that each enum item is
     substitute with an increasing number, but if later change so will the enumeration. With STRING, we store the
     exact value specified in the enum
    */
    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    /*
     With a ManyToMany relationship we need to define a join table, otherwise two table will be created by the db;
     the joinColum will set the colum from the current class that will map the other, for inverseJoinColumns stand
     the opposite. The class category will need to specify a @ManyToMany(mappedBy = "categories") option on the
     "categories" property as option in the
    */
    @ManyToMany
    @JoinTable(name = "recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    @ToString.Exclude
    private Set<Category> categories = new HashSet<>();


    public void setNotes(@NotNull Notes notes) {
        this.notes = notes;
        notes.setRecipe(this);
    }

    public Recipe addIngredient(@NotNull Ingredient ingredient) {
        ingredient.setRecipe(this);
        this.ingredients.add(ingredient);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Recipe recipe = (Recipe) o;
        return id != null && Objects.equals(id, recipe.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
