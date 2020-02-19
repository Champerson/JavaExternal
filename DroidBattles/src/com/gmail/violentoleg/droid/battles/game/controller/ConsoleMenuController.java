package com.gmail.violentoleg.droid.battles.game.controller;


import com.gmail.violentoleg.droid.battles.game.dao.InMemoryUserDao;
import com.gmail.violentoleg.droid.battles.game.model.user.UserRole;
import com.gmail.violentoleg.droid.battles.game.viewer.View;

import java.util.*;

import static com.gmail.violentoleg.droid.battles.game.model.user.UserRole.*;
import static java.util.Arrays.asList;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class ConsoleMenuController {

    private static final String DEFAULT_LANGUAGE_EN = "en";
    private static final String DEFAULT_COUNTRY_US = "US";

    private ResourceBundle resourceBundle = ResourceBundle.getBundle("messages", new Locale(DEFAULT_LANGUAGE_EN, DEFAULT_COUNTRY_US));
    private View view = new View(resourceBundle);
    private Scanner userInputScanner = new Scanner(System.in);
    private static InMemoryUserDao inMemoryUserDao = new InMemoryUserDao();
    private UserController userController = new UserController(inMemoryUserDao, view);
    private AuthorizationController authorizationController = new AuthorizationController(inMemoryUserDao, view);
    private AuthenticationManager authenticationManager = new AuthenticationManager(inMemoryUserDao);
    private AdminController adminController = new AdminController();
    private DroidController droidController = new DroidController();

    public enum Command {
        E(),
        M(),
        R(USER, ADMIN),
        A(USER, ADMIN),
        L(),
        F(ADMIN, GUEST),
        S(GUEST),
        D(USER, GUEST),
        O(GUEST);

        private UserRole[] restrictions;

        Command(UserRole... restrictions) {
            this.restrictions = restrictions;
        }

        List<UserRole> getRestrictions() {
            return asList(restrictions);
        }
    }

    public void openMainMenu() {
        view.printMainMenuOptions(filterAllowedCommands());
        String userInput = userInputScanner.nextLine().toUpperCase();
        Command command = getUserInputAsCommand(userInput);
        if (command == null) {
            view.printInvalidCommand();
            openMainMenu();
        } else if (!authenticationManager.authenticate(command.getRestrictions())) {
            view.printNotAllowedCommand();
            openMainMenu();
        } else {
            executeCommand(command);
        }
    }

    private List<Command> filterAllowedCommands() {
        UserRole userRole = inMemoryUserDao.getCurrentUser().getRole();
        return stream(Command.values()).filter(e -> !e.getRestrictions().contains(userRole)).collect(toList());
    }

    private Command getUserInputAsCommand(String userInput) {
        try {
            return Command.valueOf(userInput);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    private void executeCommand(Command command) {
        Command nextCommand = Command.E;
        switch (command) {
            case E:
                exit();
                break;
            case M:
                openMainMenu();
                break;
            case R:
                nextCommand = openRegistrationForm();
                break;
            case A:
                nextCommand = openAuthorizationForm();
                break;
            case L:
                nextCommand = openChangeLanguageForm();
                break;
            case F:
                nextCommand = openDroidFightForm();
                break;
            case S:
                nextCommand = showAllDroids();
                break;
            case D:
                nextCommand = openDroidDetailsForm();
                break;
            case O:
                nextCommand = openLogoutForm();
                break;
        }
        executeCommand(nextCommand);
    }

    private Command showAllDroids() {
        return Command.M;
    }

    private Command openDroidDetailsForm() {
        view.printEnterDroid();
        String droidNumberInput = userInputScanner.nextLine();
        return adminController.showDroidDetails(droidNumberInput);
    }

    private Command openRegistrationForm() {
        view.printRegistrationMenuOptions();
        Map.Entry<String, String> credentials = fillInCredentialsForm();
        return userController.registerUser(credentials.getKey(), credentials.getValue());
    }

    private Map.Entry<String, String> fillInCredentialsForm() {
        view.printEnterLogin();
        String inputLogin = userInputScanner.nextLine();
        view.printEnterPass();
        String inputPassword = userInputScanner.nextLine();
        return new AbstractMap.SimpleEntry<>(inputLogin, inputPassword);
    }

    private Command openAuthorizationForm() {
        view.printAuthorizationMenuOptions();
        Map.Entry<String, String> credentials = fillInCredentialsForm();
        return authorizationController.logIn(credentials.getKey(), credentials.getValue());
    }

    private Command openChangeLanguageForm() {
        view.printLanguageMenuOptions();
        String userInput = userInputScanner.nextLine();
        return userController.changeLanguage(userInput);
    }

    private Command openLogoutForm() {
        view.printLogoutForm();
        String userInput = userInputScanner.nextLine();
        if (userInput.startsWith("y")) {
            authorizationController.logOut();
        }
        return Command.M;
    }

    private Command openDroidFightForm() {
        view.printText(droidController.getAllDroids());
        view.printEnterFirstDroid();
        String firstDroidInput = userInputScanner.nextLine();
        view.printEnterSecondDroid();
        String secondDroidInput = userInputScanner.nextLine();
        droidController.doFight(firstDroidInput, secondDroidInput);
        return Command.M;
    }

    private void exit() {
        System.exit(0);
    }
}
