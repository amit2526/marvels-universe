package org.game.rpg.game.actions;

import org.game.rpg.game.actions.GameMode.Mode;
import org.game.rpg.game.actions.help.GameHelp;
import org.game.rpg.game.actions.resume.ResumeGame;
import org.game.rpg.game.actions.start.StartGame;
import org.game.rpg.game.actions.story.Story;

/**
 * This class is a factory implementation to provide instance of action class based on mode.
 *
 * Created by Amit Sharma on 3/14/2018.
 */
public class GameModeFactory {

    private GameModeFactory() {
    }

    public static GameMode getGameMode(final Mode mode) {
        switch (mode) {
            case START:
                return new StartGame();
            case RESUME:
                return new ResumeGame();
            case HELP:
                return new GameHelp();
            case STORY:
                return new Story();
            default:
                throw new UnsupportedOperationException("Mode is not valid");
        }
    }
}
