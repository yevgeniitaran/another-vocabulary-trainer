package com.yevgent.avt.vocabulary.mongo.documents;

import com.yevgent.avt.azure.Language;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "user_vocabulary_records")
@Data
public class UserVocabularyRecords {

    @Id
    private String id;
    private Language fromLanguage;
    private Language toLanguage;
    private String originalWord;

    private String translation;
    private String translation1;
    private String translation2;
    private String translation3;

    //TODO: add integration with real users
    private String user;
}
