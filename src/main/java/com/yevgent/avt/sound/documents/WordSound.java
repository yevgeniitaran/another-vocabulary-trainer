package com.yevgent.avt.sound.documents;

import com.yevgent.avt.azure.Language;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "word_sounds")
@Data
public class WordSound {

    @Id
    private String id;
    private Language language;
    private String word;

    byte[] sound;
}
