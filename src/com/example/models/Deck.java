package com.example.models;

import com.example.FaceValue;
import com.example.Suit;

import java.util.Collections;
import java.util.LinkedList;

public class Deck {

    private LinkedList<Card> cards;

    public Deck() {
        cards = new LinkedList<>();
    }


    public Deck createStandardDeck() {
        Deck deck = new Deck();
        for (Suit suit : Suit.values()){
            for (FaceValue value : FaceValue.values()){
                deck.addCardToDeck(new Card(value,suit));
            }
        }
        return deck;
    }

    public LinkedList<Card> getCards() {
        return cards;
    }

    private void addCardToDeck(Card card){
        cards.add(card);
    }

    public void shuffleDeck() {
        Collections.shuffle(cards);
    }
}

