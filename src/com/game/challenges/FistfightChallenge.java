package com.game.challenges;

import com.game.Character;
import com.game.enums.AttributeType;

public class FistfightChallenge extends AbstractChallenge {
    public FistfightChallenge() {
        super("Fistfight");
     }

    @Override
    public boolean execute(Character player, Character bot) {
        return player.getAttributeValue(AttributeType.STRENGTH) > bot.getAttributeValue(AttributeType.STRENGTH);

    }
}


