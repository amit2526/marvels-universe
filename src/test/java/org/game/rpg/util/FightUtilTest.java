package org.game.rpg.util;

import org.game.rpg.inventory.characterInventory.Character;
import org.game.rpg.inventory.weapons.Weapon;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.game.rpg.inventory.characterInventory.CharacterInventory.getEnemy;
import static org.game.rpg.inventory.characterInventory.CharacterInventory.getHero;
import static org.game.rpg.inventory.characterInventory.hero.HeroType.THOR;
import static org.game.rpg.inventory.characterInventory.villain.EnemyType.REDSKULL;

/**
 * Created by Amit Sharma on 3/16/2018.
 */
public class FightUtilTest {

    @Rule
    public SystemOutRule outRule = new SystemOutRule().enableLog();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void attack() throws Exception {
        final Character user = getHero(THOR);
        user.setWeapon(Weapon.ANTIGRAVITYGUN);

        FightUtil.attack(user, getEnemy(REDSKULL));
        assertThat(outRule.getLog())
                .contains("Hero -> Name: Thor, Weapon: ANTIGRAVITYGUN', attackPower=15, defencePower=2");
        assertThat(outRule.getLog())
                .contains("Enemy -> Name: Red Skull"); //Enemy select random weapons so we can't put in assertions.
    }

    @Test
    public void attackWithOutWeapon_AndExpectException() throws Exception {
        final Character user = getHero(THOR);
        expectedException.expect(RuntimeException.class);
        FightUtil.attack(user, getEnemy(REDSKULL));
    }
}