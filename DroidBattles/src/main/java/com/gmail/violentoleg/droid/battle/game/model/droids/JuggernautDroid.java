package com.gmail.violentoleg.droid.battle.game.model.droids;


import com.gmail.violentoleg.droid.battle.game.model.droids.strategy.BlockDefence;

public class JuggernautDroid extends Droid {

    public JuggernautDroid(int health, int damage) {
        super(health, damage, new BlockDefence());
    }
}
