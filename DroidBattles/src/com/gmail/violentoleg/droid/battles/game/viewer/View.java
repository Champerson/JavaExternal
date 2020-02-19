package com.gmail.violentoleg.droid.battles.game.viewer;


import com.gmail.violentoleg.droid.battles.game.controller.ConsoleMenuController;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.ResourceBundle;

public class View {

    private ResourceBundle resourceBundle;

    public View(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    public void setResourceBundle(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    private String getPropertyInUTF8(String propertyKey) {
        try {
            return new String(resourceBundle.getString(propertyKey).getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public void printText(String text) {
        System.out.println(text);
    }

    public void printEnterLogin() {
        System.out.print("Enter login: ");
    }

    public void printEnterPass() {
        System.out.print("Enter password: ");
    }

    public void printEnterFirstDroid() {
        System.out.println(getPropertyInUTF8("menu.user.enter.first.droid"));
    }

    public void printEnterSecondDroid() {
        System.out.println("Enter second droid number:");
    }

    public void printEnterDroid() {
        System.out.println("Enter droid number:");
    }

    public void printWelcomeHeader() {
        System.out.println("Welcome to DroidApp console menu!");
    }

    public void printMainMenuOptions(List<ConsoleMenuController.Command> menuOptions) {
        System.out.println(getPropertyInUTF8("menu.main.title"));
    }

    public void printAuthorizationMenuOptions() {
        System.out.println("Authorization menu:\nb - return back\nl - enter credentials");
    }

    public void printRegistrationMenuOptions() {
        System.out.println("Registration menu:\nb - return back\nr - provide registration details");
    }

    public void printLanguageMenuOptions() {
        System.out.println(getPropertyInUTF8("menu.language.title"));
    }

    public void printLogoutForm() {
        System.out.println("Are you sure you want to log out? type 'y' if yes or any key to cancel");
    }

    public void printUserMenuOptions() {
        System.out.println(getPropertyInUTF8("menu.user.title"));
    }

    public void printAdminMenuOptions() {
        System.out.println("Admin menu:\nl - log out\na - get all droids\nd - get droid details");
    }

    public void printInvalidData() {
        System.out.println("Input data invalid");
    }

    public void printInvalidCommand() {
        System.out.println(getPropertyInUTF8("error.menu.option"));
    }

    public void printNotAllowedCommand() {
        System.out.println("Not allowed");
    }

    public void printUserAlreadyExist() {
        System.out.println("User with this login exist");
    }

    public void printRegistrationSuccessful() {
        System.out.println("Registration successful");
    }

    public void printLoginFailed() {
        System.out.println("Log in failed");
    }
}
