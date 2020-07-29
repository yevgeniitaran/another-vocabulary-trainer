package com.yevgent.avt.sound;

import com.yevgent.avt.azure.Language;
import com.yevgent.avt.azure.SpeechService;
import com.yevgent.avt.sound.documents.WordSound;
import com.yevgent.avt.sound.repositories.WordSoundCrudRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Slf4j
public class SoundService {

    SpeechService speechService;

    WordSoundCrudRepository wordSoundCrudRepository;

    public Mono<WordSound> getWordSound(Language language, String word) {
        return wordSoundCrudRepository.findByLanguageAndWord(language, word);
    }

    public Mono<WordSound> saveWordSound(Language language, String word) {
        return wordSoundCrudRepository.findByLanguageAndWord(language, word).switchIfEmpty(
                Mono.defer(() -> {
                    byte[] sound = speechService.speechToAudioByteArray(language, word);

                    WordSound wordSound = new WordSound();
                    wordSound.setLanguage(language);
                    wordSound.setWord(word);
                    wordSound.setSound(sound);
                    return wordSoundCrudRepository.save(wordSound);
                }).subscribeOn(Schedulers.parallel()));
    }
}
