package main.java.com.gmail.violentoleg.droid.battles.game.model.droids;


import main.java.com.gmail.violentoleg.droid.battles.game.model.droids.strategy.DodgeDefence;

public class DodgerDroid extends Droid {

    public DodgerDroid(int health, int damage) {
        super(health, damage, new DodgeDefence());
    }
}
