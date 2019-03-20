package com.example;

public enum FaceValue {
    KING(10),
    QUEEN(10),
    JACK(10),
    TEN(10),
    NINE(9),
    EIGHT(8),
    SEVEN(7),
    SIX(6),
    FIVE(5),
    FOUR(4),
    THREE(3),
    TWO(2),
    ACE(1, 11);

    private final int[] values;

    FaceValue(int... i) {
        values = i;
    }


    public int NORMAL() {
        return values[0];
    }

    public int HIGH() {
        return values.length > 1 ? values[1] : values[0];
    }
}
