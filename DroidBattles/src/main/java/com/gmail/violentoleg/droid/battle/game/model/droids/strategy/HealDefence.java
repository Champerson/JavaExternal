package com.gmail.violentoleg.droid.battle.game.model.droids.strategy;


import com.gmail.violentoleg.droid.battle.game.model.droids.Defending;

import static java.lang.Math.random;

public class HealDefence implements Defending {

    private static final int HEAL_CHANCE_PERCENTS = 10;

    @Override
    public int calculateDamage(int damage) {
        return damage;
    }

    @Override
    public int reduceIncomingDamage(int damage) {
        return isDefenceApply() ? -damage : damage;
    }

    @Override
    public boolean isDefenceApply() {
        int healChance = (int) (random() * (100 / HEAL_CHANCE_PERCENTS));
        return healChance == 0;
    }
}
