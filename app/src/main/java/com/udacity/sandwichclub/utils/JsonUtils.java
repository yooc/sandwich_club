package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = new Sandwich();

        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject nameJSONObject = jsonObject.getJSONObject("name");

            sandwich.setMainName(nameJSONObject.getString("mainName"));
            sandwich.setAlsoKnownAs((List<String>) nameJSONObject.getJSONArray("alsoKnownAs"));
            sandwich.setPlaceOfOrigin(jsonObject.getString("placeOfOrigin"));
            sandwich.setDescription(jsonObject.getString("description"));
            sandwich.setImage(jsonObject.getString("image"));
            sandwich.setIngredients((List<String>) jsonObject.getJSONArray("ingredients"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sandwich;
    }
}
