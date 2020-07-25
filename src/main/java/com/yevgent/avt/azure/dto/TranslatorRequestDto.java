package com.yevgent.avt.azure.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TranslatorRequestDto {
    @JsonProperty("Text")
    String text;
}
