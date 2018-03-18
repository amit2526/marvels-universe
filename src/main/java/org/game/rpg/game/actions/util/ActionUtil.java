package org.game.rpg.game.actions.util;

import org.game.rpg.Launcher;
import org.game.rpg.util.GameUtil;
import org.game.rpg.view.View;
import org.game.rpg.view.console.ConsoleMenu;

/**
 * Created by Amit Sharma on 3/16/2018.
 */
public class ActionUtil {

    private ActionUtil() {
    }

    public static void viewPostActions() {
        final View<PostHelpAction> postHelpActionMenu =
                new ConsoleMenu<>("", "Please put operation number", PostHelpAction.values());
        final PostHelpAction postHelpAction = postHelpActionMenu.readUserChoice();
        if (postHelpAction == PostHelpAction.RETURN) {
            Launcher.launchGame();
        } else {
            GameUtil.exitGame();
        }
    }
}
