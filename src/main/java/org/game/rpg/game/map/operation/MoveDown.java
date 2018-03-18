package org.game.rpg.game.map.operation;

import org.game.rpg.inventory.characterInventory.Character;
import org.game.rpg.view.console.TickerView;

import static org.game.rpg.game.map.operation.MapRepresentationManager.CANT_MOVE_MESSAGE;
import static org.game.rpg.game.map.operation.MapRepresentationManager.UserMovement.FORWARD;
import static org.game.rpg.game.map.operation.MapRepresentationManager.getInstance;
import static org.game.rpg.game.map.operation.Operation.OperationType.DOWN;
import static org.game.rpg.game.map.operation.OperationUtil.moveVertically;

/**
 * Created by Amit Sharma on 3/15/2018.
 */
public class MoveDown implements Operation {
    private String[][] grid;

    public MoveDown() {
        this.grid = getInstance().getMapRepresentation();
    }

    @Override
    public void performOperation(final Character user) {

        if (canMoveDown(user)) {
            moveVertically(user, FORWARD, grid);
        } else {
            TickerView.displayTicker(CANT_MOVE_MESSAGE, DOWN.name());
        }
    }

    private boolean canMoveDown(final Character user) {
        return ((int) user.position().getX()) < getInstance().getMapGridSize()-1;
    }
}
