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

    @Override
    public String toString() {
        return getAbbr();
    }

    public static Language of(String abbr) {
        for (Language l : Language.values()) {
            if (l.abbr.equals(abbr)) {
                return l;
            }
        }
        throw new IllegalArgumentException("Unknown language");
    }
}
