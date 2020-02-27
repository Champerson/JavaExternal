package com.gmail.violentoleg.droid.battles.game.controller;


import com.gmail.violentoleg.droid.battles.game.dao.DroidDao;
import com.gmail.violentoleg.droid.battles.game.dao.DuelDao;
import com.gmail.violentoleg.droid.battles.game.viewer.ConsoleView;

public class AdminController {

    private DuelDao duelDao;
    private DroidDao droidDao;
    private ConsoleView consoleView;

    public AdminController(ConsoleView consoleView, DroidDao droidDao, DuelDao duelDao) {
        this.consoleView = consoleView;
        this.droidDao = droidDao;
        this.duelDao = duelDao;
    }

    public void addDroidToTheDuel(int fighter, int duel, int droid) {
        if (fighter == 1 || fighter == 2) {
            if (fighter == 1 && duelDao.getAllDuels().get(duel).getFirstFighter() == null) {
                duelDao.getAllDuels().get(duel).setFirstFighter(droidDao.getAllDroids().get(droid));
            } else if (fighter == 2 && duelDao.getAllDuels().get(duel).getSecondFighter() == null) {
                duelDao.getAllDuels().get(duel).setSecondFighter(droidDao.getAllDroids().get(droid));
            } else if (fighter == 1 && duelDao.getAllDuels().get(duel).getFirstFighter() != null || fighter == 2 && duelDao.getAllDuels().get(duel).getSecondFighter() != null){
                consoleView.showMessage("The fighter’s place is already taken");
            }
        } else {
            consoleView.showError("Unsupported exception in addDroidToTheBattle method");
        }
    }

    public void removeParticipantFromDuel(int droidToRemove, int duel) {
        if (droidToRemove == 1 || droidToRemove == 2) {
            if (droidToRemove == 1 && duelDao.getAllDuels().get(duel).getFirstFighter() != null) {
                duelDao.getAllDuels().get(duel).setFirstFighter(null);
            } else if(droidToRemove == 2 && duelDao.getAllDuels().get(duel).getSecondFighter() != null) {
                duelDao.getAllDuels().get(duel).setSecondFighter(null);
            } else {
                consoleView.showMessage("Fighter place is already empty!");
            }
        } else {
            consoleView.showError("Unsupported exception in deleteDroidFromBattle");
        }
    }

    public void replaceParticipantOfTheDuel(int droidToReplace, int duel, int droid) {
        if (droidToReplace == 1 || droidToReplace == 2) {
            if (droidToReplace == 1) {
                duelDao.getAllDuels().get(duel).setFirstFighter(droidDao.getAllDroids().get(droid));
            } else if(droidToReplace == 2) {
                duelDao.getAllDuels().get(duel).setSecondFighter(droidDao.getAllDroids().get(droid));
            }
        } else {
            consoleView.showError("Unsupported exception in replaceDroidInBattle");
        }
    }
}
