package com.gmail.violentoleg.droid.battle.game.model.droids.strategy;

import java.io.Serializable;

public interface DamageCalculation extends Serializable {

    int calculateDamage(int damage);

    int reduceIncomingDamage(int damage);
}
