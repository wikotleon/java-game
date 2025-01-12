package com.game.challenges;

import com.game.Character;
import com.game.enums.AttributeType;

public class TreasureHuntChallenge extends AbstractChallenge {
    public TreasureHuntChallenge() {
        super("TreasureHunt");
     }

    @Override
    public boolean execute(Character player, Character bot) {
        return player.getAttributeValue(AttributeType.PERCEPTION) > bot.getAttributeValue(AttributeType.PERCEPTION);

    }
}
