package org.game.rpg.view.console;

import static java.lang.System.out;

/**
 * This class used to display ticker messages on UI.
 *
 * Created by Amit Sharma on 3/15/2018.
 */
public class TickerView {

    private TickerView() {
    }

    public static void displayTicker(final String message) {
        out.println(message);
    }

    public static void displayTicker(final String message, Object... objects) {
        out.printf(message, objects);
        out.println();
    }
}
