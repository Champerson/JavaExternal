package com.gmail.violentoleg.droid.battle.game.controller;


import com.gmail.violentoleg.droid.battle.game.dao.DroidDao;
import com.gmail.violentoleg.droid.battle.game.dao.DuelDao;
import com.gmail.violentoleg.droid.battle.game.dao.UserDao;
import com.gmail.violentoleg.droid.battle.game.model.UserRole;
import com.gmail.violentoleg.droid.battle.game.model.droids.Droid;
import com.gmail.violentoleg.droid.battle.game.model.exceptions.InvalidInputTypeException;
import com.gmail.violentoleg.droid.battle.game.viewer.ConsoleView;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.InvalidObjectException;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static com.gmail.violentoleg.droid.battle.game.model.UserRole.*;
import static java.lang.String.format;
import static java.util.Arrays.asList;

public class ConsoleMenuController {

    private static final Logger LOGGER = LogManager.getLogger(ConsoleMenuController.class);

    private DuelDao duelDao = new DuelDao();
    private UserDao userDao = new UserDao();
    private ConsoleView consoleView = new ConsoleView();
    private DroidDao droidDao = new DroidDao(consoleView);
    private Scanner userInputScanner = new Scanner(System.in);
    private AuthenticationManager authenticationManager = new AuthenticationManager(userDao);
    private MessagesController messagesController = new MessagesController(consoleView);
    private DroidController droidController = new DroidController(droidDao, consoleView);
    private SerializationController serializationController = new SerializationController(droidDao);
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
        U(ADMIN, GUEST),
        B(USER, GUEST),
        J(GUEST),
        K(GUEST),
        N(USER, GUEST),
        P(USER, GUEST),
        Y(USER, GUEST);

        private UserRole[] restrictions;

        Command(UserRole... restrictions) {
            this.restrictions = restrictions;
        }

        List<UserRole> getRestrictions() {
            return asList(restrictions);
        }

    }

    public void openMainMenu() throws InvalidInputTypeException, ClassNotFoundException, InvalidObjectException {
        UserRole userAccess = userController.getCurrentUser().getRole();
        consoleView.showMessage(format(messagesController.getProperty("menu.options.description"), userAccess));
        validateCommand();
        openMainMenu();
    }

    private void openAdminMenu() throws InvalidInputTypeException, ClassNotFoundException, InvalidObjectException {
        UserRole userAccess = userController.getCurrentUser().getRole();
        consoleView.showMessage(format(messagesController.getProperty("admin.settings.menu.title"), userAccess));
        validateCommand();
        openAdminMenu();
    }

    private void openUserMenu() throws InvalidInputTypeException, ClassNotFoundException, InvalidObjectException {
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

    private void executeCommand(Command command) throws InvalidInputTypeException, InvalidObjectException, ClassNotFoundException {
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
            case B:
                openSortAllDroidsForm();
                break;
            case J:
                openMaxDamageDroidForm();
                break;
            case K:
                openMaxHealthDroidForm();
                break;
            case N:
                openCreateNewDroidForm();
                break;
            case P:
                openRemoveDroidForm();
            case Y:
                openSerializationForm();
        }
    }

    private void exit() {
        System.exit(0);
    }

    private void openAllDroidsInfo() {
        droidController.showAllDroids();
    }

    private void openAllDuelsInfo() {
        duelController.showAllDuels();
    }

    private void openRemoveDroidForm() throws InvalidInputTypeException {
        String userInput = getUserInputWithLabel("admin.form.delete.droid.label");
        droidDao.removeDroid(parseUserInput(userInput));
    }

    private void openCreateNewDroidForm() {
        String userInput = getUserInputWithLabel("admin.form.create.droid.message");
        droidDao.createNewDroid(userInput);
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

    private void openDroidDuelForm() throws InvalidInputTypeException {
        String userInput = getUserInputWithLabel("duel.number.label");
        consoleView.showMessage(format(messagesController.getProperty("duel.header.message"), duelDao.getDuel(parseUserInput(userInput)).getFirstFighter(), duelDao.getDuel(parseUserInput(userInput)).getSecondFighter()));

        duelController.startDuel(duelDao.getAllDuels().get(parseUserInput(userInput)));
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

    private void back() throws InvalidInputTypeException, ClassNotFoundException, InvalidObjectException {
        openMainMenu();
    }

    private void openAddParticipantForm() throws InvalidInputTypeException {
        String userInputParticipantNumber = getUserInputWithLabel("admin.form.participant.label");
        String userInputDuelNumber = getUserInputWithLabel("admin.form.duel.label");
        String userInputDroidNumber = getUserInputWithLabel("admin.form.droid.label");
        adminController.addDroidToTheDuel(parseUserInput(userInputParticipantNumber), parseUserInput(userInputDuelNumber), parseUserInput(userInputDroidNumber));
    }

    private void openRemoveParticipantForm() throws InvalidInputTypeException {
        String userInputParticipantNumber = getUserInputWithLabel("admin.form.participant.label");
        String userInputDuelNumber = getUserInputWithLabel("admin.form.duel.label");
        adminController.removeParticipantFromDuel(parseUserInput(userInputParticipantNumber), parseUserInput(userInputDuelNumber));
    }

    private void openReplaceParticipantForm() throws InvalidInputTypeException {
        String userInputParticipantNumber = getUserInputWithLabel("admin.form.participant.label");
        String userInputDuelNumber = getUserInputWithLabel("admin.form.duel.label");
        String userInputDroidNumber = getUserInputWithLabel("admin.form.droid.label");
        adminController.replaceParticipantOfTheDuel(parseUserInput(userInputParticipantNumber), parseUserInput(userInputDuelNumber), parseUserInput(userInputDroidNumber));
    }

    private void openAddDuelForm() throws InvalidInputTypeException {
        String userInputFirstDroidNumber = getUserInputWithLabel("admin.form.droid.label");
        String userInputSecondDroidNumber = getUserInputWithLabel("admin.form.droid.label");
        duelController.registerDuel(parseUserInput(userInputFirstDroidNumber), parseUserInput(userInputSecondDroidNumber));
    }

    private void openRemoveDuelForm() throws InvalidInputTypeException {
        String userInputDuelNumber = getUserInputWithLabel("duel.number.label");
        duelController.removeDuel(duelDao.getDuel(parseUserInput(userInputDuelNumber)));
    }

    private void openUserBetForm() throws InvalidInputTypeException {
        String duelNumber = getUserInputWithLabel("duel.number.label");
        String participantNumber = getUserInputWithLabel("user.bet.form.participant.label");
        userController.betOnDroid(parseUserInput(duelNumber), parseUserInput(participantNumber));
    }

    private void openMaxHealthDroidForm() {
        consoleView.showMessage(droidController.findDroidWithMaxHealth().toString());
    }

    private void openMaxDamageDroidForm() {
        consoleView.showMessage(droidController.findDroidWithMaxDamage().toString());
    }

    private void openSerializationForm() throws InvalidObjectException {
        serializationController.serializeDroidList();
        List<Droid> arrayList = serializationController.deserializeDroidsList();
        System.out.println(arrayList.size());
    }

    private void openSortAllDroidsForm() {
        droidController.sortAllDroidsByHealth();
    }

    private int parseUserInput(String userInput) throws InvalidInputTypeException {
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            LOGGER.warn(e);
            throw new InvalidInputTypeException(format("Invalid input type", userInput), e);
        }
    }

    private String getUserInputWithLabel(String key) {
        consoleView.showLabel(messagesController.getProperty(key));
        return userInputScanner.nextLine();
    }

    private void validateCommand() throws InvalidInputTypeException, InvalidObjectException, ClassNotFoundException {
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
