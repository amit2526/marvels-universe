package org.game.rpg.inventory.characterInventory;

import org.game.rpg.inventory.weapons.Weapon;

import java.awt.*;
import java.io.Serializable;

/**
 * Interface is used to describe Character entity.
 *
 * Created by Amit Sharma on 3/14/2018.
 */
public interface Character extends Serializable{

    /**
     * Provide name of character.
     * @return {@code String}  character name
     */
    String getName();

    /**
     * Provide acronym used for character
     * @return {@code String}  acronym
     */
    String getAcronym();

    /**
     * Provide health of a character at any point in time.
     * @return {@code int}  health
     */
    int health();

    /**
     * This will decrease health of character based on damage provided.
     * @param damage {@code int}  damage
     */
    void decreaseHealth(final int damage);

    /**
     * Provide {@link Point} position of a user at any point in time.
     * @return {@code Point} character position
     */
    Point position();

    /**
     * Set position of a character.
     * @param newPosition {@code Point} character position to set
     */
    void setPosition(final Point newPosition);

    /**
     * Provides {@link Weapon} hold by character.
     * @return Weapon
     */
    default Weapon getWeapon() {
        return null;
    }

    /**
     * Provides {@link java.util.List} of {@link Weapon}
     * @return List of weapons
     */
    default Weapon[] getWeaponList() {
        return null;
    }

    /**
     * Set {@link Weapon} for character
     * @param weapon weapon
     */
    default void setWeapon(final Weapon weapon) {
        //do nothing
    }

    /**
     * Set health of character.
     * @param health int health
     */
    default void increaseHealth(final int health) {
        //do nothing
    }

    /**
     * Indicate if a character is user.
     * @return {@code true} if character is user else {@code false}
     */
    default boolean isUser() {
        return false;
    }

    /**
     * User name who plays role of character.
     * @return String userName
     */
    default String getUserName() {
        return "no user";
    }

    /**
     * Set User name who plays role of character.
     * @param userName String userName
     */
    default void setUserName(final String userName) {
        // do nothing
    }
}
