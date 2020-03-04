package com.gmail.violentoleg.droid.battles.game.model.droids;

import static java.lang.Math.random;

public class SelfHealDroid extends Droid {

    private static final int HEAL_CHANCE_PERCENTS = 5;

    public SelfHealDroid(int health, int damage) {
        super(health, damage);
    }

    @Override
    protected int calculateDamage() {
        return this.getDamage();
    }

    @Override
    protected int reduceIncomingDamage(int damage) {
        return isHealApply() ? -damage : damage;
    }

    private boolean isHealApply() {
        int healChance = (int) (random() * (100 / HEAL_CHANCE_PERCENTS));
        return healChance == 0;
    }
}
