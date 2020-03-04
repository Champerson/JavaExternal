package com.gmail.violentoleg.droid.battles.game.model.droids;


import com.gmail.violentoleg.droid.battles.game.model.droids.strategy.SimpleDroidAttackStrategy;

public class SimpleDroid extends Droid {

    public SimpleDroid(int health, int damage) {
        super(health, damage, new SimpleDroidAttackStrategy());
    }
}
