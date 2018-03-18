package org.game.rpg.game.map.operation;

import org.game.rpg.inventory.characterInventory.Character;
import org.game.rpg.view.console.TickerView;

import static java.lang.String.format;
import static org.game.rpg.game.map.operation.MapRepresentationManager.CANT_MOVE_MESSAGE;
import static org.game.rpg.game.map.operation.MapRepresentationManager.UserMovement.BACKWARD;
import static org.game.rpg.game.map.operation.Operation.OperationType.UP;
import static org.game.rpg.game.map.operation.OperationUtil.moveVertically;

/**
 * Created by Amit Sharma on 3/15/2018.
 */
public class MoveUp implements Operation {

    private String[][] grid;

    public MoveUp() {
        this.grid = MapRepresentationManager.getInstance().getMapRepresentation();
    }

    @Override
    public void performOperation(final Character user) {
        if (canMoveUp(user)) {
            moveVertically(user, BACKWARD, grid);
        } else {
            TickerView.displayTicker(format(CANT_MOVE_MESSAGE, UP.name()));
        }
    }

    private boolean canMoveUp(final Character user) {
        return ((int) user.position().getX()) > 0;
    }
}
