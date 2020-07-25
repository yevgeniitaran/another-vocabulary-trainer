package com.yevgent.avt;

import com.yevgent.avt.azure.Language;
import com.yevgent.avt.azure.TranslatorService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
public class TranslateRestController {

    TranslatorService translatorService;

    @GetMapping("/test")
    @SneakyThrows
    public Mono<String> test() {

        return translatorService.translateByVocabulary(Language.RUSSIAN, Language.ENGLISH,"вода");
    }
}
