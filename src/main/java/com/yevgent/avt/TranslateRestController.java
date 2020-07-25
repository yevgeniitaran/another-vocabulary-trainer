package com.yevgent.avt;

import com.yevgent.avt.azure.Language;
import com.yevgent.avt.azure.TranslatorService;
import com.yevgent.avt.azure.dto.VocabularyTranslatorResponseDto;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@AllArgsConstructor
public class TranslateRestController {

    TranslatorService translatorService;

    @GetMapping("/test")
    @SneakyThrows
    public Mono<List<VocabularyTranslatorResponseDto>> test(@RequestParam(name = "word") String word) {

        return translatorService.translateByVocabulary(Language.RUSSIAN, Language.ENGLISH, word);
    }
}
