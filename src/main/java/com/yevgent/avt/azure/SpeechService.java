package com.yevgent.avt.azure;

import com.microsoft.cognitiveservices.speech.SpeechConfig;
import com.microsoft.cognitiveservices.speech.SpeechSynthesisResult;
import com.microsoft.cognitiveservices.speech.SpeechSynthesizer;
import com.yevgent.avt.config.ApplicationProperties;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SpeechService {

    ApplicationProperties applicationProperties;

    @SneakyThrows
    public byte[] speechToAudioByteArray(Language language, String text) {

        SpeechConfig config = SpeechConfig.fromSubscription(applicationProperties.getAzureSpeechKey(), applicationProperties.getAzureSpeechRegion());
        config.setSpeechSynthesisLanguage(language.getAbbr());

        SpeechSynthesizer synthesizer = new SpeechSynthesizer(config, null);
        SpeechSynthesisResult result = synthesizer.SpeakText(text);

        return result.getAudioData();
    }
}
