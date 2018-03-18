package org.game.rpg.game.map.operation;

import org.game.rpg.inventory.characterInventory.Character;
import org.game.rpg.view.console.TickerView;

import static org.game.rpg.game.map.operation.MapRepresentationManager.CANT_MOVE_MESSAGE;
import static org.game.rpg.game.map.operation.MapRepresentationManager.UserMovement.BACKWARD;
import static org.game.rpg.game.map.operation.Operation.OperationType.LEFT;
import static org.game.rpg.game.map.operation.OperationUtil.moveHorizontally;

/**
 * Created by Amit Sharma on 3/15/2018.
 */
public class MoveLeft implements Operation {
    private String[][] grid;

    public MoveLeft() {
        this.grid = MapRepresentationManager.getInstance().getMapRepresentation();
    }

    @Override
    public void performOperation(final Character user) {
        if (canMoveLeft(user)) {
            moveHorizontally(user, BACKWARD, grid);
        } else {
            TickerView.displayTicker(CANT_MOVE_MESSAGE, LEFT.name());
        }
    }

    private boolean canMoveLeft(final Character user) {
        return ((int) user.position().getY()) > 0;
    }
}
