package com.gmail.violentoleg.droid.battles.game.model.droids.strategy;

import com.gmail.violentoleg.droid.battles.game.model.droids.Defending;

import static java.lang.Math.random;

public class SelfHealDroidDefenceStrategy implements Defending {

    private static final int HEAL_CHANCE_PERCENTS = 10;

    @Override
    public int calculateDamage(int damage) {
        return damage;
    }

    @Override
    public int reduceIncomingDamage(int damage) {
        return isHealApply() ? -damage : damage;
    }

    private boolean isHealApply() {
        int healChance = (int) (random() * (100 / HEAL_CHANCE_PERCENTS));
        return healChance == 0;
    }
}
