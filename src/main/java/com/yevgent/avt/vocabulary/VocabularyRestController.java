package com.yevgent.avt.vocabulary;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vocabulary")
public class VocabularyRestController {

    @GetMapping("/words")
    List<String> getWords() {
        return List.of("word1", "word2", "word3", "word4");
    }
}
