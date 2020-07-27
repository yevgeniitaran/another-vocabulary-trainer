package com.yevgent.avt;

import com.yevgent.avt.azure.Language;
import com.yevgent.avt.azure.SpeechService;
import com.yevgent.avt.azure.TranslatorService;
import com.yevgent.avt.azure.dto.VocabularyTranslatorResponseDto;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
public class TestRestController {

    TranslatorService translatorService;
    SpeechService speechService;

    @GetMapping("/test")
    @SneakyThrows
    public Mono<VocabularyTranslatorResponseDto> test(@RequestParam(name = "word") String word) {

        return translatorService.translateByVocabulary(Language.RUSSIAN, Language.ENGLISH, word);
    }

    @GetMapping("/speech")
    @SneakyThrows
    public void testSpeech(@RequestParam(name = "text") String text) {
        speechService.speechToAudio(text);
    }
}
