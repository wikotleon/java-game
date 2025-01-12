package com.game.challenges;

import com.game.Character;

import java.util.Random;

public class TreasureHunt {
    public Character determineWinner(Character player1, Character player2) {
        Random random = new Random();
        int player1Score = player1.getPerception().getPoints() + random.nextInt(10);
        int player2Score = player2.getPerception().getPoints() + random.nextInt(10);

        if (player1Score > player2Score) {
            return player1;
        } else if (player2Score > player1Score) {
            return player2;
        } else {
            return null; // Tie
        }
    }
}