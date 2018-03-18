package org.game.rpg.game.map.operation;

import org.game.rpg.game.map.operation.Operation.OperationType;
import org.game.rpg.inventory.EntityManager;
import org.game.rpg.inventory.characterInventory.Character;
import org.game.rpg.persistance.FilePersistence;
import org.game.rpg.util.GameUtil;

import java.util.Objects;

/**
 * Created by Amit Sharma on 3/15/2018.
 */
public class OperationContext {
    private static OperationContext instance;
    private MapRepresentationManager mapRepresentationManager;

    private OperationContext(final MapRepresentationManager mapRepresentationManager) {
        this.mapRepresentationManager = mapRepresentationManager;
    }

    public static OperationContext getInstance(final MapRepresentationManager mapRepresentationManager) {
        if (Objects.isNull(instance)) {
            instance = new OperationContext(mapRepresentationManager);
        }

        return instance;
    }

    public void executeOperation(final Character user, final OperationType operationType) {
        switch (operationType) {
            case RIGHT:
                new MoveRight().performOperation(user);
                break;
            case LEFT:
                new MoveLeft().performOperation(user);
                break;
            case UP:
                new MoveUp().performOperation(user);
                break;
            case DOWN:
                new MoveDown().performOperation(user);
                break;
            case SAVE:
                new FilePersistence().persist(user.getUserName(), EntityManager.getInstance().getEntities());
                break;
            case EXIT:
                GameUtil.exitGame();
            default:
        }
    }
}
