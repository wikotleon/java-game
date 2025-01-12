package com.game.challenges;

import com.game.Character;

public class CastleConvincing {
    public Character determineWinner(Character player1, Character player2) {
        if (player1.getCharisma().getPoints() > player2.getCharisma().getPoints()) {
            return player1;
        } else if (player1.getCharisma().getPoints() < player2.getCharisma().getPoints()) {
            return player2;
        } else {
            return null; // Tie
        }
    }
}