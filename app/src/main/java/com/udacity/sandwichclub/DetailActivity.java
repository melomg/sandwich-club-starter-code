package com.udacity.sandwichclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.udacity.sandwichclub.model.Sandwich;
import com.udacity.sandwichclub.utils.JsonUtils;

import java.util.List;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_POSITION = "extra_position";
    private static final int DEFAULT_POSITION = -1;

    private TextView tvAlsoKnownAs;
    private TextView tvOrigin;
    private TextView tvDescription;
    private TextView tvIngredients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView ingredientsIv = findViewById(R.id.image_iv);
        tvAlsoKnownAs = findViewById(R.id.also_known_tv);
        tvOrigin = findViewById(R.id.origin_tv);
        tvDescription = findViewById(R.id.description_tv);
        tvIngredients = findViewById(R.id.ingredients_tv);

        Intent intent = getIntent();
        if (intent == null) {
            closeOnError();
        }

        int position = intent.getIntExtra(EXTRA_POSITION, DEFAULT_POSITION);
        if (position == DEFAULT_POSITION) {
            // EXTRA_POSITION not found in intent
            closeOnError();
            return;
        }

        String[] sandwiches = getResources().getStringArray(R.array.sandwich_details);
        String json = sandwiches[position];
        Sandwich sandwich = JsonUtils.parseSandwichJson(json);
        if (sandwich == null) {
            // Sandwich data unavailable
            closeOnError();
            return;
        }

        populateUI(sandwich);
        Picasso.with(this)
                .load(sandwich.getImage())
                .into(ingredientsIv);

        setTitle(sandwich.getMainName());
    }

    private void closeOnError() {
        finish();
        Toast.makeText(this, R.string.detail_error_message, Toast.LENGTH_SHORT).show();
    }

    private void populateUI(@NonNull Sandwich sandwich) {
        String emptyDetail = getString(R.string.empty_detail);
        final List<String> alsoKnownAs = sandwich.getAlsoKnownAs();
        if (alsoKnownAs != null) {
            for (String alsoKnown : alsoKnownAs) {
                tvAlsoKnownAs.append(alsoKnown + "\n");
            }
        }
        if (tvAlsoKnownAs.getText().toString().isEmpty()) {
            tvAlsoKnownAs.setText(emptyDetail);
        }

        final String placeOfOrigin = sandwich.getPlaceOfOrigin();
        tvOrigin.setText((TextUtils.isEmpty(placeOfOrigin)) ? emptyDetail : placeOfOrigin);

        final String description = sandwich.getDescription();
        tvDescription.setText((TextUtils.isEmpty(description)) ? emptyDetail : description);

        final List<String> ingredients = sandwich.getIngredients();
        if (ingredients != null) {
            for (String ingredient : ingredients) {
                tvIngredients.append(ingredient + "\n");
            }
        }
        if (tvIngredients.getText().toString().isEmpty()) {
            tvIngredients.setText(emptyDetail);
        }
    }
}
