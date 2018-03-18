package org.game.rpg.game.actions.story;

import org.game.rpg.game.actions.GameMode;
import org.game.rpg.game.actions.util.ActionUtil;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

import static java.lang.System.out;
import static java.lang.Thread.currentThread;
import static java.nio.file.Files.readAllLines;
import static java.util.Collections.singletonList;

/**
 * This class display help tips for user to understand the game closely.
 *
 * Created by Amit Sharma on 3/14/2018.
 */
public class Story implements GameMode {

    private static final List<String> STORY_CURRENTLY_UNAVAILABLE_MESSAGE = singletonList("Story is currently not available");

    @Override
    public void action() {
        List<String> helpMessage;
        try {
            URL resource = currentThread().getContextClassLoader().getResource("story.txt");
            if (Objects.nonNull(resource)) {
                helpMessage = readAllLines(Paths.get(resource.toURI()));
            } else {
                helpMessage = STORY_CURRENTLY_UNAVAILABLE_MESSAGE;
            }
        } catch (IOException | URISyntaxException e) {
            helpMessage = STORY_CURRENTLY_UNAVAILABLE_MESSAGE;
        }

        helpMessage.forEach(out::println);
        ActionUtil.viewPostActions();
    }
}
