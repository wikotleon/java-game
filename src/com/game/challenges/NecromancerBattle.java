package com.game.challenges;

import com.game.Character;

public class NecromancerBattle {
    private Character player1;
    private Character player2;

    public NecromancerBattle(Character player1, Character player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public Character determineWinner() {
        if (player1.getMagic().getPoints() > player2.getMagic().getPoints()) {
            return player1;
        } else if (player1.getMagic().getPoints() < player2.getMagic().getPoints()) {
            return player2;
        } else {
            return null; // It's a tie
        }
    }
}