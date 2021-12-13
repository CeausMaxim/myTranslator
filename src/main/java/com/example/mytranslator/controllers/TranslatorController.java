package com.example.mytranslator.controllers;

import com.example.mytranslator.repositories.TranslatorRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class TranslatorController {

    private TranslatorRepository translatorRepository = new TranslatorRepository();

    @GetMapping(path = "translate/word/{word}")
    public String translateWord(@PathVariable String word){
        return translatorRepository.translateWord(word);
    }
}
