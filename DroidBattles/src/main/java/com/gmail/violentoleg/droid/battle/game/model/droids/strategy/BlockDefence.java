package com.gmail.violentoleg.droid.battle.game.model.droids.strategy;


import com.gmail.violentoleg.droid.battle.game.model.droids.Defending;

import static java.lang.Math.random;

public class BlockDefence implements Defending {

    private static final int BLOCK_CHANCE_PERCENTS = 20;
    private static final int DAMAGE_REDUCTION_COEFFICIENT = 2;

    @Override
    public int calculateDamage(int droidDamage) {
        return droidDamage;
    }

    @Override
    public int reduceIncomingDamage(int damage) {
        return isDefenceApply() ? damage / DAMAGE_REDUCTION_COEFFICIENT : damage;
    }

    @Override
    public boolean isDefenceApply() {
        int blockDamageChance = (int) (random() * (100 / BLOCK_CHANCE_PERCENTS));
        return blockDamageChance == 0;
    }
}
