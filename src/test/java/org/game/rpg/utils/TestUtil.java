package org.game.rpg.utils;

import org.game.rpg.inventory.characterInventory.Character;
import org.game.rpg.inventory.characterInventory.CharacterInventory;

import java.util.LinkedList;
import java.util.List;

import static org.game.rpg.inventory.characterInventory.hero.HeroType.BATMAN;
import static org.game.rpg.inventory.characterInventory.hero.HeroType.HULK;
import static org.game.rpg.inventory.characterInventory.villain.EnemyType.*;

/**
 * Created by Amit Sharma on 3/15/2018.
 */
public class TestUtil {
    private TestUtil() {
    }

    public static List<Character> prepareListOfEntities() {
        final List<Character> entities = new LinkedList<>();
        entities.add(CharacterInventory.getEnemy(DOCTORDOOM));
        entities.add(CharacterInventory.getEnemy(MAGNETO));
        entities.add(CharacterInventory.getHero(BATMAN));
        entities.add(CharacterInventory.getEnemy(LOKI));
        entities.add(CharacterInventory.getHero(HULK));
        return entities;
    }
}
