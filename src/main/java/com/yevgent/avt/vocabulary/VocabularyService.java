package com.yevgent.avt.vocabulary;

import com.yevgent.avt.azure.Language;
import com.yevgent.avt.azure.TranslatorService;
import com.yevgent.avt.azure.dto.VocabularyTranslatorResponseDto;
import com.yevgent.avt.vocabulary.mongo.documents.VocabularyRecord;
import com.yevgent.avt.vocabulary.mongo.repositories.VocabularyRecordCrudRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class VocabularyService {

    TranslatorService translatorService;

    VocabularyRecordCrudRepository vocabularyRecordCrudRepository;

    public Mono<VocabularyRecord> getWordTranslations(Language fromLanguage, Language toLanguage, String word) {
        Mono<VocabularyRecord> translations = vocabularyRecordCrudRepository
                .findByFromLanguageAndToLanguageAndOriginalWord(fromLanguage, toLanguage, word);

        return translations.switchIfEmpty(Mono.defer(() -> {
            Mono<VocabularyTranslatorResponseDto> translation = translatorService.translateByVocabulary(fromLanguage, toLanguage, word);

            return translation.flatMap(t -> {
                VocabularyRecord record = new VocabularyRecord();
                record.setOriginalWord(word);
                record.setFromLanguage(fromLanguage);
                record.setToLanguage(toLanguage);
                for (int i = 0; i < t.getTranslations().size(); i++) {
                    if (i == 0) {
                        record.setTranslation(t.getTranslations().get(i).getDisplayTarget());
                    } else if (i == 1) {
                        record.setTranslation1(t.getTranslations().get(i).getDisplayTarget());
                    } else if (i == 2) {
                        record.setTranslation2(t.getTranslations().get(i).getDisplayTarget());
                    } else if (i == 3) {
                        record.setTranslation3(t.getTranslations().get(i).getDisplayTarget());
                        break;
                    }
                }
                return vocabularyRecordCrudRepository.save(record);
            });
        }));
    }
}
