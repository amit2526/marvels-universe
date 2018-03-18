package org.game.rpg;

import org.game.rpg.exception.ExitGameException;
import org.game.rpg.game.actions.GameMode.Mode;
import org.game.rpg.game.actions.GameModeFactory;
import org.game.rpg.view.View;
import org.game.rpg.view.console.ConsoleMenu;

/**
 * This class is entry point for Marvel's Universe game.
 * The user will be asked for mode to choose before launching game and then launch game in the user selected mode.
 *
 * Created by Amit Sharma on 3/14/2018.
 */
public class Launcher {

    public static void main(final String[] args) {
        try {
            launchGame();
        } catch (Exception exp) {
            throw new ExitGameException("Unknown exception occurred\nExiting Game");
        }
    }

    public static void launchGame() {
        final View<Mode> launchMenu = new ConsoleMenu<>(Mode.TITLE, Mode.FOOTER_MESSAGE , Mode.values());
        GameModeFactory.getGameMode(launchMenu.readUserChoice()).action();
    }
}
