package com.gmail.violentoleg.droid.battles.game.model.droids;

import com.gmail.violentoleg.droid.battles.game.model.droids.strategy.DamageCalculationStrategy;

public interface Defending extends DamageCalculationStrategy {

    int calculateDamage(int damage);

    int reduceIncomingDamage(int damage);
}
