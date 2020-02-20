package com.gmail.violentoleg.droid.battles.game.controller;


import com.gmail.violentoleg.droid.battles.game.model.droids.Droid;
import com.gmail.violentoleg.droid.battles.game.viewer.ConsoleView;

public class AdminController {

    private ConsoleView consoleView;
    //SHOULD REDO
    private BattleController battleController = new BattleController();

    public AdminController(ConsoleView consoleView) {
        this.consoleView = consoleView;
    }

    public void showDroidDetails(String droidNumber) {
        consoleView.showMessage(droidNumber + " Droid: { some details}");
    }

    //SHOULD REDO
    public void addDroidToTheBattle(Droid droid, BattleController battleController, int fighter) {
        if (fighter == 1 || fighter == 2) {
            if (fighter == 1 && battleController.getFirstFighter() != null) {
                battleController.setFirstFighter(droid);
            } else if (fighter == 2 && battleController.getSecondFighter() != null) {
                battleController.setSecondFighter(droid);
            } else {
                System.out.println("The fighter’s place is already taken");
            }
        } else {
            System.out.println("Unsupported ex int addDroidToTheBattle method");
        }
    }

    //SHOULD REDO
    public void deleteDroidFromBattle(int droidToDelete) {
        if (droidToDelete == 1 || droidToDelete == 2) {
            if (droidToDelete == 1 && battleController.getFirstFighter() != null) {
                battleController.setFirstFighter(null);
            } else if(droidToDelete == 2 && battleController.getSecondFighter() != null) {
                battleController.setSecondFighter(null);
            }
        } else {
            System.out.println("Unsupported exception in deleteDroidFromBattle");
        }
    }

    public void replaceDroidInBattle(int droidToReplace, Droid droid) {
        if (droidToReplace == 1 || droidToReplace == 2) {
            if (droidToReplace == 1) {
                battleController.setFirstFighter(droid);
            } else if(droidToReplace == 2) {
                battleController.setSecondFighter(droid);
            }
        } else {
            System.out.println("Unsupported exception in replaceDroidInBattle");
        }
    }
}
