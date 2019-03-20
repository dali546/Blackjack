package com.example.models;

import com.example.FaceValue;
import com.example.Suit;

public class Card {


    private FaceValue value;
    private Suit suit;

    public Card(FaceValue value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    public FaceValue getValue() {
        return value;
    }

    public Suit getSuit() {
        return suit;
    }
}
