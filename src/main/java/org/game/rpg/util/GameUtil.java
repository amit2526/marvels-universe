package org.game.rpg.util;

import org.game.rpg.game.map.operation.Operation.OperationType;
import org.game.rpg.view.View;
import org.game.rpg.view.console.ConsoleMenu;

import static java.lang.System.exit;
import static org.game.rpg.view.console.TickerView.displayTicker;

public class GameUtil {

    private GameUtil() {
    }

    public static String getUserName() {
        final View<String> userMenu = new ConsoleMenu<>("\nPlease enter user name", "");
        return userMenu.readInputString();
    }

    public static OperationType getOperationType() {
        final View<OperationType> directionMenu = new ConsoleMenu<>(OperationType.TITLE, OperationType.FOOTER_MESSAGE, OperationType.values());
        return directionMenu.readUserChoice();
    }

    public static void gameOver() {
        displayTicker("Game Over");
        exit(1);
    }

    public static void exitGame() {
        displayTicker("\nExiting Game");
        exit(1);
    }

    public static void youWin() {
        displayTicker("You Win!!");
        exit(1);
    }
}
