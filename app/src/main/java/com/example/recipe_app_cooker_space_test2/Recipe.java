package com.example.recipe_app_cooker_space_test2;

import java.util.List;

public class Recipe {
    int id;
    private String name;
    private List<String> ingredients;
    private List<String> steps;

    // Constructors, getters, setters


    public Recipe(int id,String name, List<String> ingredients, List<String> steps) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.steps = steps;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public List<String> getSteps() {
        return steps;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public void setSteps(List<String> steps) {
        this.steps = steps;
    }
}
