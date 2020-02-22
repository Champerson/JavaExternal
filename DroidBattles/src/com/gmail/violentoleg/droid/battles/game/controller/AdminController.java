package com.gmail.violentoleg.droid.battles.game.controller;


import com.gmail.violentoleg.droid.battles.game.dao.DroidDao;
import com.gmail.violentoleg.droid.battles.game.model.Duel;
import com.gmail.violentoleg.droid.battles.game.model.droids.Droid;
import com.gmail.violentoleg.droid.battles.game.viewer.ConsoleView;

import static com.gmail.violentoleg.droid.battles.game.model.droids.DroidType.*;

public class AdminController {

    private Duel duel;
    private DroidDao droidDao;
    private ConsoleView consoleView;

    public AdminController(ConsoleView consoleView, DroidDao droidDao) {
        this.consoleView = consoleView;
        this.droidDao = droidDao;
    }

    public void showDroidDetails(String droidNumber) {
        droidDao.createNewDroid(DAMAGE_DIALER);
        droidDao.createNewDroid(HEALER);
        droidDao.createNewDroid(TANK);
        droidDao.createNewDroid(STANDARD);
        droidDao.createNewDroid(ASSASSIN);
        consoleView.showMessage(droidDao.getAllDroids().get(Integer.parseInt(droidNumber)).toString());
    }

    public void addDroidToTheDuel(Droid droid, Duel duel, int fighter) {
        if (fighter == 1 || fighter == 2) {
            if (fighter == 1 && duel.getFirstFighter() != null) {
                duel.setFirstFighter(droid);
            } else if (fighter == 2 && duel.getSecondFighter() != null) {
                duel.setSecondFighter(droid);
            } else {
                consoleView.showMessage("The fighter’s place is already taken");
            }
        } else {
            consoleView.showError("Unsupported exception in addDroidToTheBattle method");
        }
    }

    public void removeParticipantFromDuel(int droidToDelete) {
        if (droidToDelete == 1 || droidToDelete == 2) {
            if (droidToDelete == 1 && duel.getFirstFighter() != null) {
                duel.setFirstFighter(null);
            } else if(droidToDelete == 2 && duel.getSecondFighter() != null) {
                duel.setSecondFighter(null);
            }
        } else {
            consoleView.showError("Unsupported exception in deleteDroidFromBattle");
        }
    }

    public void replaceParticipantOfTheDuel(int droidToReplace, Droid droid) {
        if (droidToReplace == 1 || droidToReplace == 2) {
            if (droidToReplace == 1) {
                duel.setFirstFighter(droid);
            } else if(droidToReplace == 2) {
                duel.setSecondFighter(droid);
            }
        } else {
            consoleView.showError("Unsupported exception in replaceDroidInBattle");
        }
    }
}
