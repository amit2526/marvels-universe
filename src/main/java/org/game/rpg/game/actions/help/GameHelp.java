package org.game.rpg.game.actions.help;

import org.game.rpg.Launcher;
import org.game.rpg.game.actions.GameMode;
import org.game.rpg.game.actions.util.ActionUtil;
import org.game.rpg.util.GameUtil;
import org.game.rpg.view.View;
import org.game.rpg.view.console.ConsoleMenu;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

import static java.lang.System.out;
import static java.lang.Thread.currentThread;
import static java.util.Collections.singletonList;

/**
 * This class displays help tips for user to understand the game closely.
 *
 * Created by Amit Sharma on 3/14/2018.
 */
public class GameHelp implements GameMode {

    private static final List<String> HELP_CURRENTLY_UNAVAILABLE_MESSAGE = singletonList("Help is currently not available");

    @Override
    public void action() {
        List<String> helpMessage;
        try {
            URL resource = currentThread().getContextClassLoader().getResource("help.txt");
            if (Objects.nonNull(resource)) {
                helpMessage = Files.readAllLines(Paths.get(resource.toURI()));
            } else {
                helpMessage = HELP_CURRENTLY_UNAVAILABLE_MESSAGE;
            }
        } catch (IOException | URISyntaxException e) {
            helpMessage = HELP_CURRENTLY_UNAVAILABLE_MESSAGE;
        }

        helpMessage.forEach(out::println);
        ActionUtil.viewPostActions();
    }
}
