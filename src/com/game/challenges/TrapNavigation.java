package com.game.challenges;

import com.game.Character;

public class TrapNavigation {
    private Character player1;
    private Character player2;

    public TrapNavigation(Character player1, Character player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public Character determineWinner() {
        if (player1.getIntelligence().getPoints() > player2.getIntelligence().getPoints()) {
            return player1;
        } else if (player1.getIntelligence().getPoints() < player2.getIntelligence().getPoints()) {
            return player2;
        } else {
            return null; // It's a tie
        }
    }
}