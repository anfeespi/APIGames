package com.anfeespi.apigames.model;

/**
 * Abstract class for all games
 */
public abstract class Game {
    private String winner;
    private int round;
    private final int players;

    public Game(int players) {
        this.winner = "";
        this.round = 0;
        this.players = players;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public int getRound() {
        return round;
    }

    public void play() {
        this.round++;
    }

    public int getPlayers() {
        return players;
    }
}
