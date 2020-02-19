package com.gmail.violentoleg.droid.battles.game.controller;


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

    private Scanner userInputScanner = new Scanner(System.in);
    private UserDao userDao = new UserDao();
    private ConsoleView consoleView = new ConsoleView();
    private AuthenticationManager authenticationManager = new AuthenticationManager(userDao);
    private MessagesController messagesController = new MessagesController(consoleView);
    private UserController userController = new UserController(messagesController, consoleView, userDao);
    private AdminController adminController = new AdminController(consoleView);
    private DroidController droidController = new DroidController(consoleView);

    private enum Command {
        E(),
        R(USER, ADMIN),
        I(USER, ADMIN),
        L(),
        F(ADMIN, GUEST),
        A(GUEST),
        D(USER, GUEST),
        O(GUEST);

        private UserRole[] restrictions;

        Command(UserRole...restrictions) {
            this.restrictions = restrictions;
        }

        List<UserRole> getRestrictions() {
            return asList(restrictions);
        }
    }

    public void openMainMenu() {
        UserRole userAccess = userController.getCurrentUser().getRole();
        consoleView.showMessage(format(messagesController.getProperty("menu.options.description"), userAccess));
        String userInput = userInputScanner.nextLine().toUpperCase();
        Command command = getUserInputAsCommand(userInput);
        if (command == null) {
            consoleView.showError(messagesController.getProperty("error.invalid.command"));
        } else if (!authenticationManager.authenticate(command.getRestrictions())) {
            consoleView.showError(messagesController.getProperty("error.access.denied"));
        } else {
            executeCommand(command);
        }
        openMainMenu();
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
                openDroidFightForm();
                break;
            case A:
                openAllDroidsInfo();
                break;
            case D:
                openDroidDetailsForm();
                break;
            case O:
                openLogoutForm();
                break;
        }
    }

    private void exit() {
        System.exit(0);
    }

    private void openAllDroidsInfo() {
        droidController.showAllDroids();
    }

    private void openDroidDetailsForm() {
        consoleView.showLabel(messagesController.getProperty("droid.number.label"));
        String droidNumberInput = userInputScanner.nextLine();
        adminController.showDroidDetails(droidNumberInput);
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

    private void openDroidFightForm() {
        droidController.showAllDroids();
        consoleView.showLabel(messagesController.getProperty("droid.number.label"));
        String firstDroidInput = userInputScanner.nextLine();
        consoleView.showLabel(messagesController.getProperty("droid.number.label"));
        String secondDroidInput = userInputScanner.nextLine();
        droidController.doFight(firstDroidInput, secondDroidInput);
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
        consoleView.showLabel(messagesController.getProperty("credentials.form.login.label"));
        String inputLogin = userInputScanner.nextLine();
        consoleView.showLabel(messagesController.getProperty("credentials.form.password.label"));
        String inputPassword = userInputScanner.nextLine();
        return new AbstractMap.SimpleEntry<>(inputLogin, inputPassword);
    }
}
