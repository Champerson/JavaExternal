package com.gmail.violentoleg.droid.battles.game.controller;


import com.gmail.violentoleg.droid.battles.game.dao.DroidDao;
import com.gmail.violentoleg.droid.battles.game.dao.DuelDao;
import com.gmail.violentoleg.droid.battles.game.viewer.ConsoleView;

public class AdminController {

    private DuelDao duelDao;
    private DroidDao droidDao;
    private ConsoleView consoleView;
    private MessagesController messagesController;

    public AdminController(MessagesController messagesController, ConsoleView consoleView, DroidDao droidDao, DuelDao duelDao) {
        this.messagesController = messagesController;
        this.consoleView = consoleView;
        this.droidDao = droidDao;
        this.duelDao = duelDao;
    }

    public void addDroidToTheDuel(int fighterNumber, int duelNumber, int droidNumber) {
        if (fighterNumber == 1 || fighterNumber == 2) {
            if (duelDao.isExist(duelNumber) && fighterNumber == 1 && duelDao.getAllDuels().get(duelNumber).getFirstFighter() == null) {
                duelDao.getDuel(duelNumber).setFirstFighter(droidDao.getDroid(droidNumber));
            } else if (duelDao.isExist(duelNumber) && fighterNumber == 2 && duelDao.getAllDuels().get(duelNumber).getSecondFighter() == null) {
                duelDao.getAllDuels().get(duelNumber).setSecondFighter(droidDao.getDroid(droidNumber));
            } else if (duelDao.isExist(duelNumber) && fighterNumber == 1 && duelDao.getAllDuels().get(duelNumber).getFirstFighter() != null || fighterNumber == 2 && duelDao.getAllDuels().get(duelNumber).getSecondFighter() != null) {
                consoleView.showError(messagesController.getProperty("error.participant.place.taken"));
            }
        } else {
            consoleView.showError(messagesController.getProperty("error.invalid.input"));
        }
    }

    public void removeParticipantFromDuel(int participantToRemove, int duelNumber) {
        if (participantToRemove == 1 || participantToRemove == 2) {
            if (duelDao.isExist(duelNumber) && participantToRemove == 1 && duelDao.getAllDuels().get(duelNumber).getFirstFighter() != null) {
                duelDao.getDuel(duelNumber).setFirstFighter(null);
            } else if (duelDao.isExist(duelNumber) && participantToRemove == 2 && duelDao.getAllDuels().get(duelNumber).getSecondFighter() != null) {
                duelDao.getAllDuels().get(duelNumber).setSecondFighter(null);
            } else {
                consoleView.showError(messagesController.getProperty("error.empty.participant.place"));
            }
        } else {
            consoleView.showError(messagesController.getProperty("error.invalid.input"));
        }
    }

    public void replaceParticipantOfTheDuel(int droidToReplace, int duel, int droid) {
        if (duelDao.isExist(duel) && droidToReplace == 1) {
            duelDao.getAllDuels().get(duel).setFirstFighter(droidDao.getDroid(droid));
        } else if (duelDao.isExist(duel) && droidToReplace == 2) {
            duelDao.getAllDuels().get(duel).setSecondFighter(droidDao.getDroid(droid));
        } else {
            consoleView.showError(messagesController.getProperty("error.invalid.input"));
        }
    }
}
