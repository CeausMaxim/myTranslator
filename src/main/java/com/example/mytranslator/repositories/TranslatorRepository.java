package com.example.mytranslator.repositories;

import com.example.mytranslator.models.Word;
import com.google.gson.Gson;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TranslatorRepository {
    public String translateWord(String word){
        String fileName = "src/main/resources/translations/"  + word + ".json";

        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(fileName));
            Word wordModel = gson.fromJson(reader, Word.class);
            reader.close();
            return wordModel.toString();
        } catch (Exception e) {
            return "word not found";
        }
    }
}
