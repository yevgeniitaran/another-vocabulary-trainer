package com.yevgent.avt.azure.dto;

import lombok.Data;

import java.util.List;

@Data
public class TranslationDto {

    String displayTarget;

    List<BackTranslationDto> backTranslations;
}
