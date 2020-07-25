package com.yevgent.avt.azure;

import com.yevgent.avt.azure.dto.TranslatorRequestDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class TranslatorService {

    TranslatorRestClient translatorRestClient;

    public Mono<String> translateByVocabulary(Language from, Language to, String word) {

        return translatorRestClient.translateByVocabulary(from, to, new TranslatorRequestDto(word));
    }
}
