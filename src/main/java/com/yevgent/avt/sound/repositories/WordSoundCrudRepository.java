package com.yevgent.avt.sound.repositories;

import com.yevgent.avt.azure.Language;
import com.yevgent.avt.sound.documents.WordSound;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface WordSoundCrudRepository extends ReactiveCrudRepository<WordSound, String> {

    Mono<WordSound> findByLanguageAndWord(Language language, String word);
}
