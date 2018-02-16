package com.udacity.sandwichclub.utils;

import android.support.annotation.Nullable;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    private JsonUtils() {
        //no-op
    }

    public static Sandwich parseSandwichJson(@Nullable String json) {
        if (json == null) {
            return null;
        }

        try {
            JSONObject jsonObject = new JSONObject(json);

            JSONObject name = jsonObject.getJSONObject("name");
            String mainName = name.getString("mainName");
            JSONArray jsonArrayAlsoKnownAs = name.getJSONArray("alsoKnownAs");
            List<String> alsoKnownAs = new ArrayList<>();
            if (jsonArrayAlsoKnownAs != null) {
                int size = jsonArrayAlsoKnownAs.length();
                for (int i = 0; i < size; i++) {
                    alsoKnownAs.add(jsonArrayAlsoKnownAs.get(i).toString());
                }
            }

            String placeOfOrigin = jsonObject.getString("placeOfOrigin");
            String description = jsonObject.getString("description");
            String image = jsonObject.getString("image");

            JSONArray jsonArrayIngredients = jsonObject.getJSONArray("ingredients");
            List<String> ingredients = new ArrayList<>();
            if (jsonArrayIngredients != null) {
                int size = jsonArrayIngredients.length();
                for (int i = 0; i < size; i++) {
                    ingredients.add(jsonArrayIngredients.get(i).toString());
                }
            }

            return new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
        } catch (JSONException e) {
            return null;
        }
    }
}
