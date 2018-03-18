package org.game.rpg.util;

import org.game.rpg.inventory.characterInventory.Character;
import org.game.rpg.inventory.characterInventory.villain.Enemy;
import org.game.rpg.inventory.weapons.Weapon;

import static org.game.rpg.view.console.TickerView.displayTicker;

/**
 * This class provides utility to get random position for User/Enemy to view on map.
 *
 * Created by Amit Sharma on 3/14/2018.
 */
public class FightUtil {

    private FightUtil() {
    }

    public static void attack(final Character hero, final Enemy enemy) {
        final Weapon enemyWeapon = enemy.selectRandomWeapon();
        final int enemyDamage = hero.getWeapon().getAttackPower() - enemyWeapon.getDefencePower();
        final int heroDamage = enemyWeapon.getAttackPower() - hero.getWeapon().getDefencePower();
        hero.decreaseHealth(heroDamage > 0 ? heroDamage : 0);
        enemy.decreaseHealth(enemyDamage > 0 ? enemyDamage : 0);
        if (hero.health() > 0 & enemy.health() > 0) {
            displayTicker(String.format("\nHero -> Name: %s, Weapon: %s, Health: %s\n", hero.getName(), hero.getWeapon(), hero.health()));
            displayTicker(String.format("Enemy -> Name: %s, Weapon: %s, Health: %s\n\n", enemy.getName(), enemyWeapon, enemy.health()));
        }
    }
}
