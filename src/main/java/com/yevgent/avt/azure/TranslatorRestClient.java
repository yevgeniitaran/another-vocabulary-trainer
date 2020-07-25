package com.yevgent.avt.azure;

import com.yevgent.avt.azure.dto.TranslatorRequestDto;
import com.yevgent.avt.azure.dto.VocabularyTranslatorResponseDto;
import com.yevgent.avt.config.ApplicationProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class TranslatorRestClient {

    ApplicationProperties applicationProperties;

    WebClient webClient = WebClient.builder()
            .clientConnector(new ReactorClientHttpConnector(
                    HttpClient.create().wiretap(true)
            ))
            .build();

    private static final String DICTIONARY_PATH = "/dictionary/lookup";
    private static final String API_VERSION = "3.0";

    @SneakyThrows
    public Mono<List<VocabularyTranslatorResponseDto>> translateByVocabulary(Language from, Language to, TranslatorRequestDto translatorRequestDto) {
        return webClient.post()
                .uri(uriBuilder -> uriBuilder.scheme("https")
                        .host(applicationProperties.getAzureTranslatorEndpoint())
                        .path(DICTIONARY_PATH)
                        .queryParam("api-version", API_VERSION)
                        .queryParam("from", from.getAbbr())
                        .queryParam("to", to.getAbbr())
                        .build())
                .header("Ocp-Apim-Subscription-Key", applicationProperties.getAzureTranslatorKey())
                .header("Ocp-Apim-Subscription-Region", applicationProperties.getAzureTranslatorRegion())
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(List.of(translatorRequestDto))
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {
                });
    }
}
