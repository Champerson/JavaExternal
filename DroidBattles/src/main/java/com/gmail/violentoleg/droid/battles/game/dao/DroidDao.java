package main.java.com.gmail.violentoleg.droid.battles.game.dao;


import main.java.com.gmail.violentoleg.droid.battles.game.model.droids.Droid;
import main.java.com.gmail.violentoleg.droid.battles.game.model.factory.Factory;
import main.java.com.gmail.violentoleg.droid.battles.game.viewer.ConsoleView;

import java.util.ArrayList;
import java.util.List;


public class DroidDao {

    Factory droidFactory;
    ConsoleView consoleView;

    public DroidDao(ConsoleView consoleView) {
        this.consoleView = consoleView;
        this.droidFactory = new Factory();
    }

    private List<Droid> allDroids = new ArrayList<>() {{
        add(droidFactory.droidFactory("juggernaut"));
        add(droidFactory.droidFactory("simple"));
        add(droidFactory.droidFactory("healer"));
        add(droidFactory.droidFactory("slayer"));
        add(droidFactory.droidFactory("dodger"));
    }};

    public void createNewDroid(String userInputDroid) {
        Droid newDroid = droidFactory.droidFactory(userInputDroid);
        if (newDroid == null) {
            consoleView.showError("Invalid input!");
        } else  {
            allDroids.add(droidFactory.droidFactory(userInputDroid));
        }
    }

    public void setAllDroids(List<Droid> allDroids) {
        this.allDroids = allDroids;
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
