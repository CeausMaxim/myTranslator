package com.example.mytranslator.controllers;

import com.example.mytranslator.models.Definition;
import com.example.mytranslator.models.Word;
import com.example.mytranslator.repositories.WordTranslatorRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class WordTranslatorController {

    private WordTranslatorRepository wordTranslatorRepository = new WordTranslatorRepository();

    @GetMapping(path = "translate/word/{language}/{word}")
    public String translateWord(@PathVariable String word, @PathVariable String language){
        return wordTranslatorRepository.translateWord(word, language);
    }

    @PostMapping(path = "translate/word/{language}")
    public boolean addWord(@RequestBody Word word, @PathVariable String language){
        return wordTranslatorRepository.addWord(word, language);
    }

    @DeleteMapping(path = "translate/word/{language}/{word}")
    public boolean deleteWord(@PathVariable String word, @PathVariable String language){
        return wordTranslatorRepository.deleteWord(word, language);
    }

    @PostMapping(path = "translate/word/{language}/{word}")
    public boolean addDefinitionForWord(@PathVariable String word, @PathVariable String language, @RequestBody Definition definition){
        return wordTranslatorRepository.addDefinitionForWord(word, language, definition);
    }

    @DeleteMapping(path = "translate/word/{language}/{word}/{dictionary}")
    public boolean deleteDefinitionForWord(@PathVariable String word, @PathVariable String language, @PathVariable String dictionary, @RequestBody Definition definition){
        return wordTranslatorRepository.deleteDefinitionForWord(word, language, definition);
    }

    @GetMapping(path = "translate/sentence/{fromLanguage}/{toLanguage}/{sentence}")
    public String translateSentences(@PathVariable String sentence, @PathVariable String fromLanguage, @PathVariable String toLanguage){
        return wordTranslatorRepository.translateSentences(fromLanguage, toLanguage, sentence);
    }

//    @GetMapping(path = "translate/word/{language}/{word}")
//    public String getDefinitionsForWord(@PathVariable String word, @PathVariable String language){
//        return wordTranslatorRepository.getDefinitionsForWord(word, language);
//    }
}
