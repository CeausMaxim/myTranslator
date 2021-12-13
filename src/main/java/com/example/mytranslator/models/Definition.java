package com.example.mytranslator.models;

import com.google.gson.Gson;

import java.util.ArrayList;

public class Definition {
    String dict;
    String dictType;
    Integer year;
    ArrayList<String> text;

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
