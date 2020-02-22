package com.gmail.violentoleg.droid.battles.game.dao;

import com.gmail.violentoleg.droid.battles.game.model.droids.Droid;
import com.gmail.violentoleg.droid.battles.game.model.droids.DroidType;
import com.gmail.violentoleg.droid.battles.game.model.factory.Factory;

import java.util.ArrayList;
import java.util.List;

import static com.gmail.violentoleg.droid.battles.game.model.droids.DroidType.*;

public class DroidDao {

    Factory droidFactory = new Factory();
    private List<Droid> allDroids = new ArrayList<>();

    public void createNewDroid(DroidType droidType) {
        allDroids.add(droidFactory.droidFactory(droidType));
    }

    public List<Droid> getAllDroids() {
        return allDroids;
    }

    public void showListOfAvailableDroids() {
        int droidNumber = 1;

        for (Droid droid : allDroids) {
            System.out.println(droidNumber+ " - " + droid.toString());
            droidNumber++;
        }
    }
}
