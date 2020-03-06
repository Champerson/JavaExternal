package com.gmail.violentoleg.droid.battle.game.controller;


import com.gmail.violentoleg.droid.battle.game.dao.DroidDao;
import com.gmail.violentoleg.droid.battle.game.model.droids.Droid;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializationController {

    private static final Logger LOGGER = LogManager.getLogger(SerializationController.class);
    private static final String DROID_SERIALIZATION_PATH = "src/main/resources/SerializedDroids.bin";

    private DroidDao droidDao;

    public SerializationController(DroidDao droidDao) {
        this.droidDao = droidDao;
    }

    public void serializeDroid() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File(DROID_SERIALIZATION_PATH)))) {
            objectOutputStream.writeObject(droidDao.getAllDroids());
            objectOutputStream.flush();
        } catch (IOException exc) {
            LOGGER.warn(exc);
        }
    }

    private List<Droid> deserializeDroidsList() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File(DROID_SERIALIZATION_PATH)))) {
            return (ArrayList<Droid>) objectInputStream.readObject();
        } catch (ClassNotFoundException | IOException exc) {
            LOGGER.warn(exc);
        }
        return null;
    }
}
