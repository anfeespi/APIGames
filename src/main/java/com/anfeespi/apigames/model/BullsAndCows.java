package com.anfeespi.apigames.model;

import java.util.Arrays;
import java.util.Random;

/**
 * Class for the Bulls and Cows game
 * <p>
 * Consist in guess the 4 numbers randomly generated only with the response of how many bulls and cows
 * do you get with the 4 played numbers.
 * Bulls: number that are in the final number and in the same position
 * Cows: number that are in the final number but in other position
 */
public class BullsAndCows extends Game {
    private final String player;
    private final int[] numbers;

    public BullsAndCows(String player) {
        super(1);
        this.player = player;

        numbers = new int[4];

        for (int i = 0; i < numbers.length; i++) {
            boolean flg = false;
            do{
                numbers[i] = new Random().nextInt(10);
                for(int j = 0; j < i; j++) {
                    if (numbers[j] == numbers[i]) {
                        flg = true;
                        break;
                    }
                }
            }while(flg);
        }
    }

    public int[] play(int[] playerTry) {
        int[] bulls_cows = new int[2];
        Arrays.fill(bulls_cows, 0);

        for (int i = 0; i < playerTry.length; i++) {
            for(int j = 0; j < numbers.length; j++) {
                if (playerTry[i] == numbers[j]) {
                    if(i == j) bulls_cows[0]++;
                    else bulls_cows[1]++;
                    break;
                }
            }
        }

        play();

        if(bulls_cows[0] == 4) setWinner(player);

        return bulls_cows;
    }

    public String getPlayer() {
        return player;
    }

}
