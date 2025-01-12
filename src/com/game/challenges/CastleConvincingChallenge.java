package com.game.challenges;

import com.game.Character;
import com.game.enums.AttributeType;

public class CastleConvincingChallenge extends AbstractChallenge {
    public CastleConvincingChallenge() {
        super("CastleConvincing");
     }

    @Override
    public boolean execute(Character player, Character bot) {
        return player.getAttributeValue(AttributeType.CHARISMA) > bot.getAttributeValue(AttributeType.CHARISMA);

    }
}
