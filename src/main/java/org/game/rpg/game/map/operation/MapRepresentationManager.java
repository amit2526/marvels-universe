package org.game.rpg.game.map.operation;

import org.game.rpg.inventory.EntityManager;
import org.game.rpg.inventory.characterInventory.Character;

import java.awt.*;
import java.util.List;

import static java.util.Objects.isNull;
import static org.game.rpg.util.RandomUtil.getRandomPoint;

/**
 * This class is used to populate game arena.
 *
 * Created by Amit Sharma on 3/14/2018.
 */
public class MapRepresentationManager {
    private static final MapRepresentationManager INSTANCE = new MapRepresentationManager();
    public static final String HEALTH = "< >";
    public static final String PADDING = "     ";
    public static final String CANT_MOVE_MESSAGE = "You can not go to %s!";

    private int mapGridSize = 5;
    private String[][] mapRepresentation = new String[mapGridSize][mapGridSize];

    public int getMapGridSize() {
        return mapGridSize;
    }

    public String[][] getMapRepresentation() {
        return mapRepresentation;
    }

    void setMapRepresentation(String[][] mapRepresentation) {
        this.mapRepresentation = mapRepresentation;
    }

    public void resetMapGrid() {
        this.mapRepresentation = new String[mapGridSize][mapGridSize];
    }

    private MapRepresentationManager() {
        //do nothing
    }

    public static MapRepresentationManager getInstance() {
        return INSTANCE;
    }

    public void initializeMapGrid() {
        final EntityManager entityManager = EntityManager.getInstance();
        List<Character> entities = entityManager.getEntities();

        entities
                .stream()
                .filter(e -> isNull(e.position()))
                .forEach(entity -> entityManager.setEntityPosition(entity, getRandomPoint())
                );

        placeHealthOptionInMap(2);

        entities.forEach(this::placeEntityInMap);
    }

    private void placeEntityInMap(final Character entity) {
        if (entity.isUser()) {
            mapRepresentation[(int) entity.position().getX()][(int) entity.position().getY()] = ">" + entity.getAcronym() + "<";
        } else {
            mapRepresentation[(int) entity.position().getX()][(int) entity.position().getY()] = "<" + entity.getAcronym() + ">";
        }
    }

    private void placeHealthOptionInMap(final int times) {
        for (int counter = 0; counter < times; counter++) {
            final Point randomPoint = getRandomPoint();
            mapRepresentation[(int) randomPoint.getX()][(int) randomPoint.getY()] = "<" + HEALTH + ">";
        }
    }

    enum UserMovement {
        FORWARD(1),
        BACKWARD(-1);

        private final int value;

        UserMovement(final int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
