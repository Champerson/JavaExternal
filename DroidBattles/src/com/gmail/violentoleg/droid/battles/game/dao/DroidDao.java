package com.gmail.violentoleg.droid.battles.game.dao;

import com.gmail.violentoleg.droid.battles.game.model.droids.Droid;
import com.gmail.violentoleg.droid.battles.game.model.factory.Factory;

import java.util.ArrayList;
import java.util.List;


public class DroidDao {

    Factory droidFactory = new Factory();
    private List<Droid> allDroids = new ArrayList<Droid>() {{
        add(droidFactory.droidFactory(0));
        add(droidFactory.droidFactory(1));
        add(droidFactory.droidFactory(2));
        add(droidFactory.droidFactory(3));
        add(droidFactory.droidFactory(4));
    }};

    public void createNewDroid(int droidNumber) {
        allDroids.add(droidFactory.droidFactory(droidNumber));
    }

    public List<Droid> getAllDroids() {
        return allDroids;
    }

    public Droid getDroid(int droidNumber) {
        if (allDroids.size() <= droidNumber || droidNumber < 0) {
            return null;
        } else {
            return allDroids.get(droidNumber);
        }
    }
}
