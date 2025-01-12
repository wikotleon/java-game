package com.game.challenges;

import com.game.Character;

public class ForestEscape {
    public Character determineWinner(Character player1, Character player2) {
        if (player1.getEndurance().getPoints() > player2.getEndurance().getPoints()) {
            return player1;
        } else if (player1.getEndurance().getPoints() < player2.getEndurance().getPoints()) {
            return player2;
        } else {
            return null; // It's a tie
        }
    }
}