package com.example.damiank.pomyslna.data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MyRecipe {

    @JsonProperty("record")
    public List<Recipe> records = new ArrayList<Recipe>();
}
