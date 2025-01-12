package com.game.challenges;

import com.game.Character;

public interface Challenge {
    String getName();
    boolean execute(Character player, Character bot);
}