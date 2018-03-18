package org.game.rpg.game.actions.help;

import org.game.rpg.game.actions.util.PostHelpAction;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Amit Sharma on 3/15/2018.
 */
public class GameHelpTest {

    @Rule
    public SystemOutRule outRule = new SystemOutRule().enableLog();

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void helpAction() throws Exception {
        //given
        final InputStream in = new ByteArrayInputStream("2".getBytes());
        System.setIn(in);

        exit.expectSystemExitWithStatus(1);
        //when
        new GameHelp().action();

        //then
        assertThat(outRule.getLog()).contains(PostHelpAction.RETURN.toString());
        assertThat(outRule.getLog()).contains(PostHelpAction.EXIT.toString());
        assertThat(outRule.getLog()).contains("Exiting Game");

    }
}