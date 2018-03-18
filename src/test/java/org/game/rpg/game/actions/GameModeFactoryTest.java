package org.game.rpg.game.actions;

import org.game.rpg.game.actions.GameMode.Mode;
import org.game.rpg.game.actions.help.GameHelp;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.game.rpg.game.actions.GameModeFactory.getGameMode;

public class GameModeFactoryTest {

    @Test
    public void getGameAction_ForHelp_AndExpectInstanceOfGameHelp() {
        final GameMode gameMode = getGameMode(Mode.HELP);
        assertThat(gameMode).isInstanceOf(GameHelp.class);
    }

    @Test
    public void getGameAction_ForResume_AndExpectInstanceOfResumeGame() {
        final GameMode gameMode = getGameMode(Mode.HELP);
        final InputStream in = new ByteArrayInputStream("User".getBytes());
        System.setIn(in);
        assertThat(gameMode).isInstanceOf(GameHelp.class);
    }
}