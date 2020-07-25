package com.yevgent.avt.azure;

import com.microsoft.cognitiveservices.speech.ResultReason;
import com.microsoft.cognitiveservices.speech.SpeechConfig;
import com.microsoft.cognitiveservices.speech.SpeechSynthesisResult;
import com.microsoft.cognitiveservices.speech.SpeechSynthesizer;
import com.microsoft.cognitiveservices.speech.audio.AudioConfig;
import com.yevgent.avt.config.ApplicationProperties;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
@AllArgsConstructor
public class SpeechService {

    ApplicationProperties applicationProperties;

    @SneakyThrows
    public void speechToAudio(String text) {
        String audioFileName = "helloworld.wav";

        SpeechConfig config = SpeechConfig.fromSubscription(applicationProperties.getAzureSpeechKey(), applicationProperties.getAzureSpeechRegion());

        AudioConfig audioOutput = AudioConfig.fromWavFileInput(audioFileName);

        SpeechSynthesizer synth = new SpeechSynthesizer(config, audioOutput);

        Future<SpeechSynthesisResult> task = synth.SpeakTextAsync(text);

        SpeechSynthesisResult result = task.get();

        if (result.getReason() == ResultReason.SynthesizingAudioCompleted) {
            System.out.println("Speech synthesized to [" + audioFileName + "] for text [" + text + "]");
        }
    }
}
