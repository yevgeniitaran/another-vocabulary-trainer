package com.yevgent.avt.sound;

import com.yevgent.avt.azure.Language;
import com.yevgent.avt.sound.documents.WordSound;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_OCTET_STREAM_VALUE;

@RestController
@RequestMapping("/api/v1/sounds")
@AllArgsConstructor
public class SoundRestController {

    private final SoundService soundService;

    @GetMapping(produces = APPLICATION_OCTET_STREAM_VALUE)
    Mono<byte[]> getSound(@RequestParam(name = "language") Language language,
                          @RequestParam(name = "word") String word) {

        return soundService.getWordSound(language, word)
                .map(WordSound::getSound);
    }
}
