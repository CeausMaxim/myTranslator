package com.example.mytranslator.models;

import com.google.gson.Gson;

import java.util.ArrayList;

public class Word {
    String word;
    String word_en;
    String type;
    ArrayList<String> singular;
    ArrayList<String> plural;
    ArrayList<Definition> definitions;

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
