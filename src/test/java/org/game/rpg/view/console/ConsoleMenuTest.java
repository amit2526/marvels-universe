package org.game.rpg.view.console;

import org.game.rpg.game.actions.GameMode.Mode;
import org.game.rpg.view.View;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class ConsoleMenuTest {

    @Rule
    public SystemOutRule outRule = new SystemOutRule().enableLog();

    @Before
    public void setUp() throws Exception {
        outRule.clearLog();
    }

    @After
    public void tearDown() throws Exception {
        outRule.clearLog();
        System.setIn(System.in);
    }

    @Test
    public void readUserChoiceForStart() {
        final View<Mode> view = new ConsoleMenu<>(Mode.TITLE, Mode.FOOTER_MESSAGE, Mode.values());
        final InputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        final Mode outputMode = view.readUserChoice();
        assertThat(outputMode).isEqualTo(Mode.START);
    }

    @Test
    public void readUserChoiceForResume() {
        final View<Mode> view = new ConsoleMenu<>(Mode.TITLE, Mode.FOOTER_MESSAGE, Mode.values());
        final InputStream in = new ByteArrayInputStream("2".getBytes());
        System.setIn(in);
        final Mode outputMode = view.readUserChoice();
        assertThat(outputMode).isEqualTo(Mode.RESUME);
    }

    @Test
    public void testShowMap() {
        final View<Mode> view = new ConsoleMenu<>(Mode.TITLE, Mode.FOOTER_MESSAGE, Mode.values());
        final InputStream in = new ByteArrayInputStream("3".getBytes());
        System.setIn(in);
        final Mode outputMode = view.readUserChoice();
        assertThat(outputMode).isEqualTo(Mode.HELP);
        assertThat(outRule.getLog()).contains(Mode.START.toString());
        assertThat(outRule.getLog()).contains(Mode.HELP.toString());
        assertThat(outRule.getLog()).contains(Mode.RESUME.toString());
    }
}