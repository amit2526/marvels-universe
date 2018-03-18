package org.game.rpg.game.actions.story;

import org.game.rpg.game.actions.help.GameHelp;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.game.rpg.game.actions.util.PostHelpAction.EXIT;
import static org.game.rpg.game.actions.util.PostHelpAction.RETURN;

/**
 * Created by Amit Sharma on 3/16/2018.
 */
public class StoryTest {

    @Rule
    public SystemOutRule outRule = new SystemOutRule().enableLog();

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void storyAction() throws Exception {
        //given
        final InputStream in = new ByteArrayInputStream("2".getBytes());
        System.setIn(in);

        exit.expectSystemExitWithStatus(1);

        //when
        new Story().action();

        //then
        assertThat(outRule.getLog()).contains("Exiting Game");
        assertThat(outRule.getLog()).contains(RETURN.toString());
        assertThat(outRule.getLog()).contains(EXIT.toString());

    }
}