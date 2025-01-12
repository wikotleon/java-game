package com.game.challenges;

import com.game.Character;

public abstract class AbstractChallenge implements Challenge {
    private final String name;

    public AbstractChallenge(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public abstract boolean execute(Character player, Character bot);
}