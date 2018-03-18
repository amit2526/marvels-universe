package org.game.rpg.view;

/**
 * This interface is used for displaying(on Console/UI) and rendering related components(OP/IP) .
 *
 * Created by Amit Sharma on 3/14/2018.
 */
public interface View<T> {
    /**
     * This method is used to display provided menu on UI.
     */
    void displayMenu();

    /**
     * This method will read input choice from user.
     * Input choice is mainly restricted to no. of operation given on screen (UI/Console).
     *
     * @return input choice from user
     */
    default T readUserChoice() {
        return null;
    }

    /**
     * This method is created to read input string submitted by user.
     * Input can be a user name, details proived for saving and resuming game, etc.
     * @return input string from user
     */
    default String readInputString() {
        return null;
    }
}
