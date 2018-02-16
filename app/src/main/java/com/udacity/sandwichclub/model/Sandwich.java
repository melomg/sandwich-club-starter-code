package com.udacity.sandwichclub.model;

import android.support.annotation.Nullable;

import java.util.List;

public class Sandwich {

    @Nullable
    private String mainName;
    @Nullable
    private List<String> alsoKnownAs = null;
    @Nullable
    private String placeOfOrigin;
    @Nullable
    private String description;
    @Nullable
    private String image;
    @Nullable
    private List<String> ingredients = null;

    /**
     * No args constructor for use in serialization
     */
    public Sandwich() {
    }

    public Sandwich(@Nullable String mainName, @Nullable List<String> alsoKnownAs,
                    @Nullable String placeOfOrigin, @Nullable String description,
                    @Nullable String image, @Nullable List<String> ingredients) {
        this.mainName = mainName;
        this.alsoKnownAs = alsoKnownAs;
        this.placeOfOrigin = placeOfOrigin;
        this.description = description;
        this.image = image;
        this.ingredients = ingredients;
    }

    @Nullable
    public String getMainName() {
        return mainName;
    }

    public void setMainName(@Nullable String mainName) {
        this.mainName = mainName;
    }

    @Nullable
    public List<String> getAlsoKnownAs() {
        return alsoKnownAs;
    }

    public void setAlsoKnownAs(@Nullable List<String> alsoKnownAs) {
        this.alsoKnownAs = alsoKnownAs;
    }

    @Nullable
    public String getPlaceOfOrigin() {
        return placeOfOrigin;
    }

    public void setPlaceOfOrigin(@Nullable String placeOfOrigin) {
        this.placeOfOrigin = placeOfOrigin;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    public void setDescription(@Nullable String description) {
        this.description = description;
    }

    @Nullable
    public String getImage() {
        return image;
    }

    public void setImage(@Nullable String image) {
        this.image = image;
    }

    @Nullable
    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(@Nullable List<String> ingredients) {
        this.ingredients = ingredients;
    }
}
