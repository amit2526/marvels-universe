package org.game.rpg.game.map.operation;

import org.game.rpg.inventory.characterInventory.Character;
import org.game.rpg.view.console.TickerView;

import static org.game.rpg.game.map.operation.MapRepresentationManager.CANT_MOVE_MESSAGE;
import static org.game.rpg.game.map.operation.MapRepresentationManager.UserMovement.FORWARD;
import static org.game.rpg.game.map.operation.MapRepresentationManager.getInstance;
import static org.game.rpg.game.map.operation.Operation.OperationType.RIGHT;
import static org.game.rpg.game.map.operation.OperationUtil.moveHorizontally;

/**
 * Created by Amit Sharma on 3/15/2018.
 */
public class MoveRight implements Operation {

    private String[][] grid;

    public MoveRight() {
        this.grid = getInstance().getMapRepresentation();
    }

    @Override
    public void performOperation(Character user) {

        if (canMoveRight(user)) {
            moveHorizontally(user, FORWARD, grid);
        } else {
            TickerView.displayTicker(CANT_MOVE_MESSAGE, RIGHT.name());
        }
    }

    private boolean canMoveRight(Character user) {
        return ((int) user.position().getY()) < getInstance().getMapGridSize()-1;
    }
}
