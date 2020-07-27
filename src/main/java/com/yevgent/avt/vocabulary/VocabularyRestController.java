package com.yevgent.avt.vocabulary;

import com.yevgent.avt.azure.Language;
import com.yevgent.avt.vocabulary.mongo.documents.VocabularyRecord;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vocabulary")
@AllArgsConstructor
public class VocabularyRestController {

    VocabularyService vocabularyService;

    @GetMapping("/words")
    List<String> getWords() {
        return List.of("word1", "word2", "word3", "word4");
    }

    @GetMapping("/translations")
    Mono<VocabularyRecord> getTranslations(@RequestParam(name = "from") Language from,
                                           @RequestParam(name = "to") Language to,
                                           @RequestParam(name = "word") String word) {
        return vocabularyService.getWordTranslations(from, to, word);
    }
}
