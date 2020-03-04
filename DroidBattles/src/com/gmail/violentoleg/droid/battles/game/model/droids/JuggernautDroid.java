package com.gmail.violentoleg.droid.battles.game.model.droids;

import static java.lang.Math.random;

public class JuggernautDroid extends Droid {

    private static final int BLOCK_CHANCE_PERCENTS = 20;
    private static final int DAMAGE_REDUCTION_COEFFICIENT = 2;

    public JuggernautDroid(int health, int damage) {
        super(health, damage);
    }

    @Override
    protected int calculateDamage() {
        return this.getDamage();
    }

    @Override
    protected int reduceIncomingDamage(int damage) {
        return isBlockApply() ? damage / DAMAGE_REDUCTION_COEFFICIENT : damage;
    }

    private boolean isBlockApply() {
        int blockDamageChance = (int) (random() * (100 / BLOCK_CHANCE_PERCENTS));
        return blockDamageChance == 0;
    }
}
