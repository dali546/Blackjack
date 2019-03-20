package com.example;

public enum Suit {
    HEARTS("\u2661"),
    SPADES("\u2660"),
    CLUBS("\u2663"),
    DIAMONDS("\u2666");

    private String[] values;

    Suit(String... s) {
        values = s;
    }

    public String SYMBOL() {
        return values[0];
    }
}
