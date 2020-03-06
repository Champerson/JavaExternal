package main.java.com.gmail.violentoleg.droid.battles.game.model.droids;


import main.java.com.gmail.violentoleg.droid.battles.game.model.droids.strategy.DamageCalculation;

public interface Attacking extends DamageCalculation {

    int calculateDamage(int damage);

    int reduceIncomingDamage(int damage);

    boolean isAttackApply();
}
