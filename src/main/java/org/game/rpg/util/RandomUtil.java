package org.game.rpg.util;

import org.game.rpg.game.map.operation.MapRepresentationManager;

import java.awt.*;
import java.util.Random;

/**
 * This class provides utility to get random position for User/Enemy to view on map.
 *
 * Created by Amit Sharma on 3/14/2018.
 */
public class RandomUtil {
    private static final Random random = new Random();
    private static final MapRepresentationManager USER_MOVEMENT = MapRepresentationManager.getInstance();

    public static Point getRandomPoint() {
        final Point point = new Point(random.nextInt(USER_MOVEMENT.getMapGridSize()), random.nextInt(USER_MOVEMENT.getMapGridSize()));
        if (positionTaken(point, USER_MOVEMENT.getMapRepresentation())) {
            return getRandomPoint();
        }
        return point;
    }

    private static boolean positionTaken(final Point point, final String[] [] grid) {
        String pointStr = grid[(int) point.getX()][(int) point.getY()];
        if (pointStr == null) {
            return false;
        } else {
            return !pointStr.isEmpty();
        }
    }
}
