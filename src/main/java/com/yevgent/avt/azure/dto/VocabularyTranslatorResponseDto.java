package com.yevgent.avt.azure.dto;

import lombok.Data;

import java.util.List;

@Data
public class VocabularyTranslatorResponseDto {

    List<TranslationDto> translations;
}
