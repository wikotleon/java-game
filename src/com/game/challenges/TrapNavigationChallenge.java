package com.game.challenges;

import com.game.Character;
import com.game.enums.AttributeType;

public class TrapNavigationChallenge extends AbstractChallenge {
    public TrapNavigationChallenge() {
        super("TrapNavigation");
     }

    @Override
    public boolean execute(Character player, Character bot) {
        return player.getAttributeValue(AttributeType.INTELLIGENCE) > bot.getAttributeValue(AttributeType.INTELLIGENCE);

    }
}
