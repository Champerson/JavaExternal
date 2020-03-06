package main.java.com.gmail.violentoleg.droid.battles.game.model.droids.strategy;

import main.java.com.gmail.violentoleg.droid.battles.game.model.droids.Defending;

import static java.lang.Math.random;

public class DodgeDefence implements Defending {

    private static final int DODGE_CHANCE_PERCENTS = 20;

    @Override
    public int calculateDamage(int damage) {
        return damage;
    }

    @Override
    public int reduceIncomingDamage(int damage) {
        return isDefenceApply() ? 0 : damage;
    }

    @Override
    public boolean isDefenceApply() {
        int dodgeChance = (int) (random() * (100 / DODGE_CHANCE_PERCENTS));
        return dodgeChance == 0;
    }
}
