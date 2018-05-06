package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = new Sandwich();

        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject sandwichNameJSONObject = jsonObject.getJSONObject("name");

            ArrayList<String> alsoKnownAsListData = new ArrayList<>();
            JSONArray akaJArray = sandwichNameJSONObject.getJSONArray("alsoKnownAs");
            if (akaJArray != null) {
                for (int i=0 ; i < akaJArray.length() ; i++){
                    alsoKnownAsListData.add((String) akaJArray.get(i));
                }
            }

            ArrayList<String> ingredientsListData = new ArrayList<>();
            JSONArray ingredientsJArray = jsonObject.getJSONArray("ingredients");
            if (ingredientsJArray != null) {
                for (int i=0 ; i < ingredientsJArray.length() ; i++){
                    ingredientsListData.add((String) ingredientsJArray.get(i));
                }
            }

            sandwich.setMainName(sandwichNameJSONObject.getString("mainName"));
            sandwich.setAlsoKnownAs(alsoKnownAsListData);
            sandwich.setPlaceOfOrigin(jsonObject.getString("placeOfOrigin"));
            sandwich.setDescription(jsonObject.getString("description"));
            sandwich.setImage(jsonObject.getString("image"));
            sandwich.setIngredients(ingredientsListData);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sandwich;
    }
}
