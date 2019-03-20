package com.example;

import com.example.models.Deck;
import com.example.models.Player;
import com.sun.org.glassfish.gmbal.ParameterNames;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private Deck gameDeck;
    private Player player, dealer;
    private String winner;
    private boolean isEnded;

    public Game(Deck deck) {
        this.gameDeck = deck;
        player = new Player(false);
        dealer = new Player(true);
        isEnded = false;
    }

    public void startFirstRound() {
        player.dealCard(gameDeck.getCards().pop());
        dealer.dealCard(gameDeck.getCards().pop());
        player.dealCard(gameDeck.getCards().pop());
        dealer.dealCard(gameDeck.getCards().pop());
        postRoundCheck(player);
    }

    private void postRoundCheck(Player p) {
        showPlayerCards(p);
        if (isWon(p)) {
            winner = p.getName();
            isEnded = true;
            return;
        } else if (isBust(p)) {
            if (p == dealer) winner = "Player"; else winner = "Dealer";
            isEnded = true;
            return;
        }
        if (p == dealer) dealerPlay();
        else hitOrStand();
    }

    private boolean isWon(Player p) {
        //Use LOW total if HIGH total exceeds 21.
        if (playerHasAce(p) && p.getTotal() > 21 && p.getLowTotal() == 21) return true;
        return p.getTotal() == 21;
    }

    private boolean isBust(Player p) {
        if (playerHasAce(p) && p.getLowTotal() > 21) return true;
        return p.getLowTotal() > 21;
    }

    private boolean playerHasAce(Player p) {
        return p.getCards().stream().anyMatch(card -> card.getValue() == FaceValue.ACE);
    }

    private void hitOrStand() {
        Scanner scanner = new Scanner(System.in);
        String c;
        do {
            System.out.println("(H)it or (S)tand?");
            c = scanner.next();
        } while (!c.matches("[HhSs]"));

        if (c.equalsIgnoreCase("h")) nextRound();
        else stand();
    }

    private void stand() {
        postRoundCheck(dealer);
    }

    private void showPlayerCards(Player player) {
        System.out.println(player.getName() + "'s hand");
        player.getCards().forEach(card ->
                System.out.printf("Card %s: %s of %s (%s)\n",
                        player.getCards().indexOf(card) + 1,
                        card.getValue(),
                        card.getSuit(),
                        card.getSuit().SYMBOL()));
        System.out.println("Total: " + (player.getTotal() > player.getLowTotal() ? player.getTotal() : player.getLowTotal()));
    }

    public List<Player> getPlayers() {
        return new ArrayList<Player>() {{
            add(player);
            add(dealer);
        }};
    }

    public boolean isEnded() {
        return isEnded;
    }

    public void nextRound() {
        player.dealCard(gameDeck.getCards().pop());
        postRoundCheck(player);
    }

    public String getWinner() {
        return winner;
    }

    private void dealerPlay() {
        int playerScore = player.getTotal() < 21 ? player.getTotal() : player.getLowTotal();
        while (dealer.getTotal() < 21 ? dealer.getTotal() < playerScore : dealer.getLowTotal() < playerScore) {
            dealer.dealCard(gameDeck.getCards().pop());
            postRoundCheck(dealer);
        }
        winner = "Dealer";
        isEnded = true;
    }
}
