package org.game.rpg.persistance;

import org.game.rpg.inventory.characterInventory.Character;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;
import static org.game.rpg.view.console.TickerView.displayTicker;

/**
 * This class provides File store implementation of {@link Persistence} interface.
 *
 * Created by Amit Sharma on 3/14/2018.
 */
public class FilePersistence implements Persistence {

    private static final String SAVE_MESSAGE = "Game Saved Successfully";
    private static final String STATE_NOT_SAVED = "Game is not saved for this user";
    private static final String UNSUCCESSFUL_SAVE = "Unable to save game";
    private static final String RESOURCE_PATH = "src/main/resources/";

    @Override
    public boolean persist(final String userName, final List<Character> entities) {
        Path filePath;
        try {
            filePath = Paths.get(format("%s%s.txt", RESOURCE_PATH, userName));
            if (Files.exists(filePath)) {
                Files.delete(filePath);
            }
            return saveEntities(entities, filePath);
        } catch (Exception exp) {
            displayTicker(UNSUCCESSFUL_SAVE);
            return false;
        }
    }

    @Override
    public List<Character> load(final String userName) {
        final Path filePath = Paths.get(format("%s%s.txt", RESOURCE_PATH, userName));
        List<Character> entities = new ArrayList<>();
        try (FileInputStream fileInputStream = new FileInputStream(filePath.toString());
             ObjectInputStream in = new ObjectInputStream(fileInputStream)){

            while (fileInputStream.available() > 1) {
                Character character = (Character) in.readObject();
                entities.add(character);
            }
        } catch (IOException | ClassNotFoundException e) {
            displayTicker(STATE_NOT_SAVED);
            return null;
        }
        return entities;
    }

    private boolean saveEntities(final List<Character> entities, final Path filePath) throws IOException {
        try(FileOutputStream fileOutputStream = new FileOutputStream(filePath.toString());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            for (Character entity : entities) {
                objectOutputStream.writeObject(entity);
                objectOutputStream.reset();
            }
        }

        displayTicker(SAVE_MESSAGE);
        return true;
    }
}
