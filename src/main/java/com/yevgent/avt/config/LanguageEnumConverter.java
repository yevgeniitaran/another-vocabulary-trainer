package com.yevgent.avt.config;

import com.yevgent.avt.azure.Language;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class LanguageEnumConverter implements Converter<String, Language> {
    @Override
    public Language convert(String value) {
        return Language.of(value);
    }
}
