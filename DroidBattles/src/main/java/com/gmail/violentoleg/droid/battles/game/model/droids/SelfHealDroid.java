package main.java.com.gmail.violentoleg.droid.battles.game.model.droids;


import main.java.com.gmail.violentoleg.droid.battles.game.model.droids.strategy.HealDefence;

public class SelfHealDroid extends Droid {


    public SelfHealDroid(int health, int damage) {
        super(health, damage, new HealDefence());
    }
}
