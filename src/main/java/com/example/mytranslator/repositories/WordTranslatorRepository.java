package com.example.mytranslator.repositories;

import com.example.mytranslator.models.Definition;
import com.example.mytranslator.models.Word;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class WordTranslatorRepository {
    private Gson gson = new Gson();
    public String translateWord(String word, String language){
        String fileName = "src/main/resources/translations/" +  language + "/"  + word + ".json";
        try {
            Reader reader = Files.newBufferedReader(Paths.get(fileName));
            Word wordModel = gson.fromJson(reader, Word.class);
            reader.close();
            return wordModel.toString();
        } catch (Exception e) {
            return "word not found";
        }
    }

    public String translateSentences(String sentence, String fromLanguage, String toLanguage){
        // Add path for sentence. From and to Language
        String filenameFrom = "src/main/resources/translations/" + fromLanguage + "/cat.json";
        String filenameTo = "src/main/resources/translations/" + toLanguage + "/pisica.json";
        try {
            Reader reader = Files.newBufferedReader(Paths.get(toLanguage));
            Word wordModel = gson.fromJson(reader, Word.class);
            reader.close();
            return wordModel.toString();
        } catch (Exception e) {
            return "sentence not found";
        }
    }

    public boolean addWord(Word word, String language){
        String fileName = "src/main/resources/translations/" +  language + "/"  + word.word + ".json";
        try {
            Writer writer = new FileWriter(fileName);
            gson.toJson(word, writer);
            writer.close();
        } catch (Exception e){
            return false;
        }
        return true;
    }

    public boolean deleteWord(String word, String language){
        String fileName = "src/main/resources/translations/" +  language + "/"  + word + ".json";
        try {
            File file = new File(fileName);
            file.delete();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean addDefinitionForWord(String word, String language, Definition definition){
        String fileName = "src/main/resources/translations/" +  language + "/"  + word + ".json";
        try {
            Reader reader = Files.newBufferedReader(Paths.get(fileName));
            Word wordModel = gson.fromJson(reader, Word.class);
            reader.close();
            wordModel.definitions.add(definition);//todo
            try {
                Writer writer = new FileWriter(fileName);
                gson.toJson(wordModel, writer);
                writer.close();
            } catch (Exception e){
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteDefinitionForWord(String word, String language, Definition definition){
        String fileName = "src/main/resources/translations/" +  language + "/"  + word + ".json";
        try {
            Reader reader = Files.newBufferedReader(Paths.get(fileName));
            Word wordModel = gson.fromJson(reader, Word.class);
            reader.close();
            wordModel.definitions.remove(definition);
            try {
                Writer writer = new FileWriter(fileName);
                gson.toJson(wordModel, writer);
                writer.close();
            } catch (Exception e){
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

//        ArrayList<String> text = new ArrayList<String>();
//        JSONArray jsonArray = (JSONArray)jsonObject;
//        int len = jsonArray.length();
//        // ?????? ?????????????? ???? ??????????????
//        if (jsonArray != null) {
//            for (int i=0;i<len;i++){
//                text.add(jsonArray.get(i).toString());
//            }
//        }
//        //???????????????? ???? ??????????????
//        text.remove(position);
//        //?????????????????????? json ??????????????
//        JSONArray jsArray = new JSONArray(text);
}
