package com.game.challenges;

import com.game.Character;
import com.game.enums.AttributeType;

public class NecromancerBattleChallenge extends AbstractChallenge {
    public NecromancerBattleChallenge() {
        super("Necromancer Battle");
     }

    @Override
    public boolean execute(Character player, Character bot) {
        return player.getAttributeValue(AttributeType.MAGIC) > bot.getAttributeValue(AttributeType.MAGIC);

    }
}
