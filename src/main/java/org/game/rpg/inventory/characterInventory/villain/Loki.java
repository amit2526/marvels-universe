package org.game.rpg.inventory.characterInventory.villain;

import org.game.rpg.inventory.weapons.Weapon;

import java.awt.*;

public class Loki extends Enemy {
    private EnemyType enemyType = EnemyType.LOKI;
    private int health = enemyType.getHealth();
    private Point position;

    @Override
    public Weapon selectRandomWeapon() {
        return Weapon.chooseRandom();
    }

    @Override
    public String getName() {
        return enemyType.getName();
    }

    @Override
    public int health() {
        return this.health;
    }

    @Override
    public void decreaseHealth(final int damage) {
        this.health -= damage;
    }

    @Override
    public Point position() {
        return position;
    }

    @Override
    public void setPosition(final Point newPosition) {
        this.position = newPosition;
    }

    @Override
    public String getAcronym() {
        return enemyType.getAcronym();
    }
}
