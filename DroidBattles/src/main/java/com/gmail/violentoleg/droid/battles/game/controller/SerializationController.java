package com.gmail.violentoleg.droid.battles.game.controller;

import com.gmail.violentoleg.droid.battles.game.model.droids.Droid;
import com.gmail.violentoleg.droid.battles.game.viewer.ConsoleView;

import java.io.*;

public class SerializationController {

    ConsoleView consoleView;

    public boolean serializeDroid(Droid droid, String fileName) {
        boolean flag = false;
        File f = new File(fileName);
        ObjectOutputStream objectOutputStream = null;

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(f);
            if (fileOutputStream != null) {
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(droid); // ������������
                flag = true;
            }
        } catch (FileNotFoundException e) {
            consoleView.showError("File cannot be created: " + e);
        } catch (NotSerializableException e) {
            consoleView.showError("Class does not support serialization: " + e);
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            try {
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
            } catch (IOException e) {
                consoleView.showError("Stream close error");
            }
        }
        return flag;
    }

    public Droid deserialization(String fileName) throws InvalidObjectException {
        File fr = new File(fileName);
        ObjectInputStream objectInputStream = null;

        try {
            FileInputStream fis = new FileInputStream(fr);
            objectInputStream = new ObjectInputStream(fis);
            Droid st = (Droid) objectInputStream.readObject();
            return st;
        } catch (ClassNotFoundException ce) {
            consoleView.showError("Class does not exist: " + ce);
        } catch (
                FileNotFoundException e) {
            consoleView.showError("File for deserialization does not exist: " + e);
        } catch (
                InvalidClassException ioe) {
            consoleView.showError("Class version mismatch: " + ioe);
        } catch (
                IOException ioe) {
            consoleView.showError("Common I/O error: " + ioe);
        } finally {
            try {
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
            } catch (IOException e) {
                consoleView.showError("Stream close error ");
            }
        }
        throw new InvalidObjectException("Object does not restored");
    }
}
