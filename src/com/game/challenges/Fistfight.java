package com.game.challenges;

import com.game.Character;

public class Fistfight {
    public Character determineWinner(Character player1, Character player2) {
        if (player1.getStrength().getPoints() > player2.getStrength().getPoints()) {
            return player1;
        } else if (player1.getStrength().getPoints() < player2.getStrength().getPoints()) {
            return player2;
        } else {
            return null; // It's a tie
        }
    }
}