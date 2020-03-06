package main.java.com.gmail.violentoleg.droid.battles.game.controller;

import main.java.com.gmail.violentoleg.droid.battles.game.dao.DroidDao;
import main.java.com.gmail.violentoleg.droid.battles.game.dao.DuelDao;
import main.java.com.gmail.violentoleg.droid.battles.game.model.Duel;
import main.java.com.gmail.violentoleg.droid.battles.game.viewer.ConsoleView;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AdminControllerTest {
    private static DuelDao duelDao = new DuelDao();
    private static DroidDao droidDao = new DroidDao();
    private static ConsoleView consoleView = new ConsoleView();
    private static MessagesController messagesController = new MessagesController(consoleView);
    private static AdminController adminController = new AdminController(messagesController, consoleView, droidDao, duelDao);

    @Before
    public void setUp() throws Exception {
        duelDao.getAllDuels().add(new Duel());
    }

    @Test
    public void addDroidToTheDuelCorrect() {
        adminController.addDroidToTheDuel(2, 1, 1);
        Assert.assertSame(duelDao.getDuel(1).getSecondFighter(), droidDao.getDroid(1));
    }

    @Test
    public void removeParticipantFromDuel() {
        adminController.removeParticipantFromDuel(1, 0);
        Assert.assertNull(duelDao.getDuel(0).getFirstFighter());
    }

    @Test
    public void replaceParticipantOfTheDuel() {
        adminController.replaceParticipantOfTheDuel(1, 0, 1);
        Assert.assertSame(duelDao.getDuel(0).getFirstFighter(), droidDao.getDroid(1));
    }
}