package com.gmail.violentoleg.droid.battles.game.dao;

import com.gmail.violentoleg.droid.battles.game.model.droids.Droid;
import com.gmail.violentoleg.droid.battles.game.model.droids.DroidType;
import com.gmail.violentoleg.droid.battles.game.model.factory.Factory;

import java.util.ArrayList;
import java.util.List;

import static com.gmail.violentoleg.droid.battles.game.model.droids.DroidType.*;


public class DroidDao {

    Factory droidFactory = new Factory();
    private List<Droid> allDroids = new ArrayList<Droid>() {{
        add(droidFactory.droidFactory(STANDARD));
        add(droidFactory.droidFactory(TANK));
        add(droidFactory.droidFactory(DAMAGE_DIALER));
        add(droidFactory.droidFactory(HEALER));
        add(droidFactory.droidFactory(ASSASSIN));
    }};

    public void createNewDroid(DroidType droidType) {
        allDroids.add(droidFactory.droidFactory(droidType));
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

    public void showAllDroids() {
        int droidNumber = 0;

        for (Droid droid : allDroids) {
            System.out.println(droidNumber + " - " + droid.toString());
            droidNumber++;
        }
    }
}
