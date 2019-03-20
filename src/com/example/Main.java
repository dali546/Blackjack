package com.example;

import com.example.models.Deck;

import java.util.Scanner;

public class Main {

    private static Deck deck;

    public static void main(String[] args) {
        System.out.println("Welcome To Blackjack");
        deck = new Deck().createStandardDeck();
        deck.shuffleDeck();
        System.out.println("1. Start Playing");
        Scanner scanner = new Scanner(System.in);
        //int option = Integer.parseInt(scanner.next());
        playGame();
    }

    private static void playGame() {
        //if (option == 1) {
        playStandardGame();
        //}
    }

    private static void playStandardGame() {
        Game game = new Game(deck);
        game.startFirstRound();
        while (!game.isEnded()) {
            game.nextRound();
        }
        if (game.getWinner().equals("Player")) {
            System.out.println("Nice, You won. Dealer Bust. Your final score:");
        } else {
            System.out.println("Damn You Lost. your final score: ");
        }
        System.out.print(game.getPlayers().get(0).getTotal());
    }
}
