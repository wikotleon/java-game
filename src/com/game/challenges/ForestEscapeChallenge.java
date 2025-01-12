package com.game.challenges;

import com.game.Character;
import com.game.enums.AttributeType;

public class ForestEscapeChallenge extends AbstractChallenge {
    public ForestEscapeChallenge() {
        super("ForestEscape");
     }

    @Override
    public boolean execute(Character player, Character bot) {
        return player.getAttributeValue(AttributeType.ENDURANCE) > bot.getAttributeValue(AttributeType.ENDURANCE);

    }
}
