package org.game.rpg.game.map.operation;

import org.game.rpg.game.map.operation.MapRepresentationManager.UserMovement;
import org.game.rpg.inventory.characterInventory.Character;
import org.game.rpg.inventory.characterInventory.villain.Enemy;
import org.game.rpg.inventory.weapons.Weapon;
import org.game.rpg.util.FightUtil;
import org.game.rpg.util.GameUtil;
import org.game.rpg.view.View;
import org.game.rpg.view.console.ConsoleMenu;
import org.game.rpg.view.console.TickerView;

import java.awt.*;

import static java.util.Objects.nonNull;
import static org.game.rpg.game.map.operation.MapRepresentationManager.HEALTH;
import static org.game.rpg.game.map.operation.MapRepresentationManager.PADDING;
import static org.game.rpg.inventory.EntityManager.getInstance;
import static org.game.rpg.inventory.characterInventory.CharacterInventory.getEnemy;
import static org.game.rpg.inventory.characterInventory.villain.EnemyType.enemyTypeStartedWith;
import static org.game.rpg.view.console.TickerView.displayTicker;

/**
 * Created by Amit Sharma on 3/15/2018.
 */
class OperationUtil {

    private OperationUtil() {
    }

    static void moveHorizontally(final Character user, final UserMovement movement, final String[][] grid) {
        checkEnemy(user, movement.getValue(), "y", grid);
        grid [(int) user.position().getX()] [(int) user.position().getY()] = PADDING;
        user.setPosition(new Point((int) user.position().getX(), (int) user.position().getY() + movement.getValue()));
        grid [(int) user.position().getX()] [(int) user.position().getY()] = "<"+user.getAcronym()+">";
    }

    static void moveVertically(final Character user, final UserMovement movement, final String[][] grid) {
        checkEnemy(user, movement.getValue(), "x", grid);
        grid[(int) user.position().getX()][(int) user.position().getY()] = PADDING;
        user.setPosition(new Point((int) user.position().getX() + movement.getValue(), (int) user.position().getY()));
        grid[(int) user.position().getX()][(int) user.position().getY()] = "<"+user.getAcronym()+">";
    }

    private static void checkEnemy(final Character user, final int distance, final String axis, final String[][] grid) {
        String str;
        if (axis.equalsIgnoreCase("y")) {
            str = grid[(int) user.position().getX()][(int) user.position().getY() + distance];
        } else {
            str = grid[(int) user.position().getX() + distance][(int) user.position().getY()];
        }
        if (nonNull(str) && !str.isEmpty()) {
            if (!str.equals(PADDING)) {
                if (str.contains(HEALTH)) {
                    user.increaseHealth(50);
                    TickerView.displayTicker("Congratulations!! Your health Increases by 50. Your health now is %s\n", user.health());
                } else {
                    fight(user, getEnemy(enemyTypeStartedWith(str)));
                }
            }
        }
    }

    private static void fight(final Character user, final Enemy enemy) {
        displayTicker("\nHero -> Name: %s, Health: %s", user.getName(), user.health());
        displayTicker("Enemy -> Name: %s, Health: %s", enemy.getName(), enemy.health());

        final View<Weapon> weaponMenu = new ConsoleMenu<>(Weapon.TITLE, Weapon.FOOTER_MESSAGE, user.getWeaponList());
        Weapon userWeapon = weaponMenu.readUserChoice();
        user.setWeapon(userWeapon);
        FightUtil.attack(user, enemy);
        if (user.health() <= 0) {
            GameUtil.gameOver();
        }

        if (enemy.health() <= 0) {
            getInstance().removeEntity(enemy);
            return;
        }
        fight(user, enemy);
    }
}
