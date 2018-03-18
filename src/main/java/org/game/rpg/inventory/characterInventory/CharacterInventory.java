package org.game.rpg.inventory.characterInventory;

import org.game.rpg.inventory.characterInventory.hero.*;
import org.game.rpg.inventory.characterInventory.villain.*;

public class CharacterInventory {
    private CharacterInventory() {
    }

    public static Character getHero(final HeroType type) {
        switch (type) {
            case SPIDERMAN:
                return new Spiderman();
            case HULK:
                return new Hulk();
            case BATMAN:
                return new Batman();
            case IROMMAN:
                return new Ironman();
            case THOR:
                return new Thor();
            default:
                throw new UnsupportedOperationException("Not a valid character type");
        }
    }

    public static Enemy getEnemy(final EnemyType type) {
        switch (type) {
            case DOCTORDOOM:
                return new DoctorDoom();
            case MAGNETO:
                return new Magneto();
            case REDSKULL:
                return new RedSkull();
            case LOKI:
                return new Loki();
            case THANOS:
                return new Thanos();
            default:
                throw new UnsupportedOperationException("Not a valid character type");
        }
    }
}
