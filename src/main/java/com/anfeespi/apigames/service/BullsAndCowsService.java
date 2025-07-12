package com.anfeespi.apigames.service;

import com.anfeespi.apigames.model.BullsAndCows;
import org.springframework.stereotype.Service;

@Service
public class BullsAndCowsService {
    private BullsAndCows game;

    public boolean create(String player) {
        game = new BullsAndCows(player);
        return true;
    }

    public int[] play(int[] playerTry) {
        return game.play(playerTry);
    }
}
