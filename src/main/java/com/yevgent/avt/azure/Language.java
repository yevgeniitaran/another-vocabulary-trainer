package com.yevgent.avt.azure;

public enum Language {

    RUSSIAN("ru"),
    ENGLISH("en"),
    GERMAN("de");

    private final String abbr;

    Language(String abbr) {
        this.abbr = abbr;
    }

    public String getAbbr() {
        return abbr;
    }
}
