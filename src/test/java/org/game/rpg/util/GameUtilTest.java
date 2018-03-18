package org.game.rpg.util;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Amit Sharma on 3/16/2018.
 */
public class GameUtilTest {

    @Rule
    public SystemOutRule sysOutRule = new SystemOutRule().enableLog();

    @Rule
    public ExpectedSystemExit expectedSystemExit = ExpectedSystemExit.none();

    @After
    public void tearDown() throws Exception {
        System.setIn(System.in);
    }

    @Test
    public void getUserNameTest() throws Exception {
        //given
        final String userName = "Test User Name";
        final InputStream in = new ByteArrayInputStream(userName.getBytes());
        System.setIn(in);

        //when
        final String output = GameUtil.getUserName();

        //then
        assertThat(output).isEqualTo(userName);
    }

    @Test
    public void exitGameTest() throws Exception {
        expectedSystemExit.expectSystemExitWithStatus(1);
        GameUtil.exitGame();
        assertThat(sysOutRule.getLog()).contains("Exiting Game");
    }

    @Test
    public void gameOverTest() throws Exception {
        expectedSystemExit.expectSystemExitWithStatus(1);
        GameUtil.gameOver();
        assertThat(sysOutRule.getLog()).contains("Game Over");
    }


    @Test
    public void winDisplayTest() throws Exception {
        expectedSystemExit.expectSystemExitWithStatus(1);
        GameUtil.youWin();
        assertThat(sysOutRule.getLog()).contains("You Win!!");
    }
}