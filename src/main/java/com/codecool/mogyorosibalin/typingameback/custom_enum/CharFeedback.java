package com.codecool.mogyorosibalin.typingameback.custom_enum;

import java.util.HashMap;
import java.util.Map;

public enum CharFeedback {

    CORRECT("CORRECT"),
    WRONG("WRONG"),
    UNPRODUCTIVE("UNPRODUCTIVE");

    private String charFeedback;

    private static final Map<String, CharFeedback> lookup = new HashMap<>();
    static {
        for(CharFeedback charFeedback : CharFeedback.values()) {
            lookup.put(charFeedback.getCharFeedback(), charFeedback);
        }
    }
    public static CharFeedback getCharFeedback(String charFeedback) {
        return lookup.get(charFeedback);
    }

    CharFeedback(String charFeedback) {
        this.charFeedback = charFeedback;
    }

    public String getCharFeedback() {
        return this.charFeedback;
    }

}
