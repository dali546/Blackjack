package com.example.models;

import java.util.LinkedList;

public class Player {

    private LinkedList<Card> cards;
    private boolean isDealer;
    private String name;

    public Player(boolean isDealer) {
        this.cards = new LinkedList<>();
        this.isDealer = isDealer;
        name = this.isDealer ? "Dealer" : "Player";
    }

    public boolean isDealer() {

        return isDealer;
    }

    public void dealCard(Card card) {
        cards.add(card);
    }

    public LinkedList<Card> getCards() {
        return cards;
    }

    public int getTotal() {
        return cards.stream().mapToInt(card -> card.getValue().HIGH()).sum();
    }

    public int getLowTotal() {
        return cards.stream().mapToInt(card -> card.getValue().NORMAL()).sum();
    }

    public String getName() {
        return name;
    }
}
