package com.yevgent.avt.vocabulary.documents;

import com.yevgent.avt.azure.Language;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "vocabulary_records")
@Data
public class VocabularyRecord {

    @Id
    private String id;
    private Language fromLanguage;
    private Language toLanguage;
    private String originalWord;

    private String translation;
    private String translation1;
    private String translation2;
    private String translation3;
}
