package org.game.rpg.game.actions.start;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * Created by Amit Sharma on 3/15/2018.
 */
public class StartGameTest {

    private StartGame startGameMode;

    @Before
    public void setUp() throws Exception {
        final InputStream choice = new ByteArrayInputStream("1".getBytes());
        System.setIn(choice);
        /*final InputStream name = new ByteArrayInputStream("TestStartGame".getBytes());
        System.setIn(name);*/
        this.startGameMode = new StartGame();
    }

    @Test
    public void startActonTest() throws Exception {
        startGameMode.action();
        final InputStream name = new ByteArrayInputStream("TestStartGame".getBytes());
        System.setIn(name);
    }

}