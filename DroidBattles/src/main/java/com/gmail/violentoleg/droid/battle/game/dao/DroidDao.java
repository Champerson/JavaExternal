package com.gmail.violentoleg.droid.battle.game.dao;


import com.gmail.violentoleg.droid.battle.game.model.droids.*;
import com.gmail.violentoleg.droid.battle.game.model.factory.Factory;
import com.gmail.violentoleg.droid.battle.game.viewer.ConsoleView;

import java.util.ArrayList;
import java.util.List;


public class DroidDao {

    private Factory droidFactory;
    private ConsoleView consoleView;

    public DroidDao(ConsoleView consoleView) {
        this.consoleView = consoleView;
        this.droidFactory = new Factory();
    }

    private List<Droid> allDroids = new ArrayList<>() {{
        add(new SimpleDroid(700, 40));
        add(new DodgerDroid(500, 40));
        add(new SlayerDroid(400, 60));
        add(new SelfHealDroid(500, 40));
        add(new JuggernautDroid(800, 30));
    }};

    public void createNewDroid(String userInputDroid) {
        Droid createdDroid = droidFactory.droidFactory(userInputDroid);
        if (createdDroid == null) {
            consoleView.showError("Invalid input!");
        } else {
            allDroids.add(droidFactory.droidFactory(userInputDroid));
        }
    }

    public void setAllDroids(List<Droid> allDroids) {
        this.allDroids = allDroids;
    }

    public void removeDroid(int droidNumber) {
        if (allDroids.size() <= droidNumber || droidNumber < 0) {
            consoleView.showError("Invalid input!");
        } else {
            allDroids.remove(droidNumber);
        }
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
