package com.yevgent.avt.vocabulary.mongo.repositories;

import com.yevgent.avt.azure.Language;
import com.yevgent.avt.vocabulary.mongo.documents.VocabularyRecord;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface VocabularyRecordCrudRepository
        extends ReactiveCrudRepository<VocabularyRecord, String> {

    Mono<VocabularyRecord> findByFromLanguageAndToLanguageAndOriginalWord(Language fromLanguage,
                                                                          Language toLanguage, String value);
}