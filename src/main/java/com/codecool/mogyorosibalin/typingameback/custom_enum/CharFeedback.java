package com.codecool.mogyorosibalin.typingameback.custom_enum;

public enum CharFeedback {

    CORRECT(1),
    WRONG(2),
    UNPRODUCTIVE(3);

    private int value;

    private static CharFeedback[] allValues = values();
    public static CharFeedback fromInteger(int i) { return allValues[i]; }

    CharFeedback(int value) {
        this.value = value;
    }

}
