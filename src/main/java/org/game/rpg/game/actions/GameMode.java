package org.game.rpg.game.actions;

/**
 * Interface is used to perform actions based on selected game mode.
 *
 * Created by Amit Sharma on 3/14/2018.
 */
@FunctionalInterface
public interface GameMode {
    void action();

    enum Mode {
        START("Start New Game"),
        RESUME("Resume Saved Game"),
        HELP("Help Tips"),
        STORY("Story Mode");

        private String name;

        Mode(final String name) {
            this.name = name;
        }

        public static final String TITLE = "Welcome to Marvel's Universe\n\nChoose Mode";
        public static final String FOOTER_MESSAGE = "Please put operation number";

        @Override
        public String toString() {
            return  name;
        }
    }
}
