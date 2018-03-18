package org.game.rpg.inventory.characterInventory.villain;

import org.game.rpg.inventory.characterInventory.Character;
import org.game.rpg.inventory.weapons.Weapon;

public abstract class Enemy implements Character {
    public abstract Weapon selectRandomWeapon();
}
