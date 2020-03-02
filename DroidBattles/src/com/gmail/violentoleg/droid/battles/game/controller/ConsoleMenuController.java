package com.gmail.violentoleg.droid.battles.game.controller;


import com.gmail.violentoleg.droid.battles.game.dao.DroidDao;
import com.gmail.violentoleg.droid.battles.game.dao.DuelDao;
import com.gmail.violentoleg.droid.battles.game.dao.UserDao;
import com.gmail.violentoleg.droid.battles.game.model.user.UserRole;
import com.gmail.violentoleg.droid.battles.game.viewer.ConsoleView;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static com.gmail.violentoleg.droid.battles.game.model.user.UserRole.*;
import static java.lang.String.format;
import static java.util.Arrays.asList;

public class ConsoleMenuController {

    private UserDao userDao = new UserDao();
    private DroidDao droidDao = new DroidDao();
    private ConsoleView consoleView = new ConsoleView();
    private DuelDao duelDao = new DuelDao(consoleView);
    private Scanner userInputScanner = new Scanner(System.in);
    private MessagesController messagesController = new MessagesController(consoleView);
    private AuthenticationManager authenticationManager = new AuthenticationManager(userDao);
    private UserController userController = new UserController(messagesController, consoleView, userDao, duelDao);
    private DuelController duelController = new DuelController(messagesController, consoleView, duelDao, droidDao);
    private AdminController adminController = new AdminController(messagesController, consoleView, droidDao, duelDao);

    private enum Command {
        E(),
        R(USER, ADMIN),
        I(USER, ADMIN),
        O(GUEST),
        L(),
        M(USER, GUEST),
        D(GUEST),
        A(GUEST),
        S(ADMIN, GUEST),
        Q(GUEST),
        Z(USER, GUEST),
        X(USER, GUEST),
        C(USER, GUEST),
        V(USER, GUEST),
        F(ADMIN, GUEST),
        G(USER, GUEST),
        U(ADMIN, GUEST);

        private UserRole[] restrictions;

        Command(UserRole... restrictions) {
            this.restrictions = restrictions;
        }

        List<UserRole> getRestrictions() {
            return asList(restrictions);
        }

    }

    public void openMainMenu() {
        UserRole userAccess = userController.getCurrentUser().getRole();
        consoleView.showMessage(format(messagesController.getProperty("menu.options.description"), userAccess));
        validateCommand();
        openMainMenu();
    }

    private void openAdminMenu() {
        UserRole userAccess = userController.getCurrentUser().getRole();
        consoleView.showMessage(format(messagesController.getProperty("admin.settings.menu.title"), userAccess));
        validateCommand();
        openAdminMenu();
    }

    private void openUserMenu() {
        UserRole userAccess = userController.getCurrentUser().getRole();
        consoleView.showMessage(format(messagesController.getProperty("user.menu.title"), userAccess));
        validateCommand();
        openUserMenu();
    }


    private Command getUserInputAsCommand(String userInput) {
        try {
            return Command.valueOf(userInput);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    private void executeCommand(Command command) {
        switch (command) {
            case E:
                exit();
                break;
            case R:
                openRegistrationForm();
                break;
            case I:
                openAuthorizationForm();
                break;
            case L:
                openChangeCountryLanguageForm();
                break;
            case F:
                openDroidDuelForm();
                break;
            case A:
                openAllDroidsInfo();
                break;
            case M:
                openAdminMenu();
                break;
            case O:
                openLogoutForm();
                break;
            case U:
                openUserMenu();
                break;
            case Q:
                back();
                break;
            case Z:
                openAddParticipantForm();
                break;
            case X:
                openRemoveParticipantForm();
                break;
            case C:
                openReplaceParticipantForm();
                break;
            case D:
                openAllDuelsInfo();
                break;
            case G:
                openAddDuelForm();
                break;
            case V:
                openRemoveDuelForm();
                break;
            case S:
                openUserBetForm();
                break;
        }
    }

    private void exit() {
        System.exit(0);
    }

    private void openAllDroidsInfo() {
        droidDao.showAllDroids();
    }

    private void openAllDuelsInfo() {
        duelDao.showAllDuels();
    }

    private void openChangeCountryLanguageForm() {
        consoleView.showMessage(messagesController.getProperty("language.change.title"));
        String userInput = userInputScanner.nextLine();
        messagesController.changeLanguage(userInput);
    }

    private void openLogoutForm() {
        consoleView.showMessage(messagesController.getProperty("logout.confirmation.message"));
        String userInput = userInputScanner.nextLine();
        if (userInput.startsWith("y")) {
            userController.logOut();
        }
    }

    private void openDroidDuelForm() {
        String userInput = getUserInputWithLabel("duel.number.label");
        consoleView.showMessage(format(messagesController.getProperty("duel.header.message"), duelDao.getDuel(Integer.parseInt(userInput)).getFirstFighter(), duelDao.getDuel(Integer.parseInt(userInput)).getSecondFighter()));

        duelController.startDuel(duelDao.getAllDuels().get(Integer.parseInt(userInput)));
    }

    private void openRegistrationForm() {
        consoleView.showMessage(messagesController.getProperty("registration.form.title"));
        Map.Entry<String, String> credentials = fillInCredentialsForm();
        userController.registerUser(credentials.getKey(), credentials.getValue());
    }

    private void openAuthorizationForm() {
        consoleView.showMessage(messagesController.getProperty("authorization.form.title"));
        Map.Entry<String, String> credentials = fillInCredentialsForm();
        userController.authorize(credentials.getKey(), credentials.getValue());
    }

    private Map.Entry<String, String> fillInCredentialsForm() {
        String inputLogin = getUserInputWithLabel("credentials.form.login.label");
        String inputPassword = getUserInputWithLabel("credentials.form.password.label");
        return new AbstractMap.SimpleEntry<>(inputLogin, inputPassword);
    }

    private void back() {
        openMainMenu();
    }

    private void openAddParticipantForm() {
        String userInputParticipantNumber = getUserInputWithLabel("admin.form.participant.label");
        String userInputDuelNumber = getUserInputWithLabel("admin.form.duel.label");
        String userInputDroidNumber = getUserInputWithLabel("admin.form.droid.label");
        adminController.addDroidToTheDuel(Integer.parseInt(userInputParticipantNumber), Integer.parseInt(userInputDuelNumber), Integer.parseInt(userInputDroidNumber));
    }

    private void openRemoveParticipantForm() {
        String userInputParticipantNumber = getUserInputWithLabel("admin.form.participant.label");
        String userInputDuelNumber = getUserInputWithLabel("admin.form.duel.label");
        adminController.removeParticipantFromDuel(Integer.parseInt(userInputParticipantNumber), Integer.parseInt(userInputDuelNumber));
    }

    private void openReplaceParticipantForm() {
        String userInputParticipantNumber = getUserInputWithLabel("admin.form.participant.label");
        String userInputDuelNumber = getUserInputWithLabel("admin.form.duel.label");
        String userInputDroidNumber = getUserInputWithLabel("admin.form.droid.label");
        adminController.replaceParticipantOfTheDuel(Integer.parseInt(userInputParticipantNumber), Integer.parseInt(userInputDuelNumber), Integer.parseInt(userInputDroidNumber));
    }

    private void openAddDuelForm() {
        String userInputFirstDroidNumber = getUserInputWithLabel("admin.form.droid.label");
        String userInputSecondDroidNumber = getUserInputWithLabel("admin.form.droid.label");
        duelController.registerDuel(Integer.parseInt(userInputFirstDroidNumber), Integer.parseInt(userInputSecondDroidNumber));
    }

    private void openRemoveDuelForm() {
        String userInputDuelNumber = getUserInputWithLabel("duel.number.label");
        duelController.removeDuel(duelDao.getDuel(Integer.parseInt(userInputDuelNumber)));
    }

    private void openUserBetForm() {
        String duelNumber = getUserInputWithLabel("duel.number.label");
        String participantNumber = getUserInputWithLabel("user.bet.form.participant.label");
        userController.betOnDroid(Integer.parseInt(duelNumber), Integer.parseInt(participantNumber));
    }

    private String getUserInputWithLabel(String key) {
        consoleView.showLabel(messagesController.getProperty(key));
        return userInputScanner.nextLine();
    }

    private void validateCommand() {
        String userInput = userInputScanner.nextLine().toUpperCase();
        Command command = getUserInputAsCommand(userInput);
        if (command == null) {
            consoleView.showError(messagesController.getProperty("error.invalid.command"));
        } else if (!authenticationManager.authenticate(command.getRestrictions())) {
            consoleView.showError(messagesController.getProperty("error.access.denied"));
        } else {
            executeCommand(command);
        }
    }
}
