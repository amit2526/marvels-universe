package org.game.rpg.inventory.weapons;

import java.util.Random;

public enum Weapon {
    MJOLNIR("MJOLNIR", 10, 4),
    GAUNTLET("GAUNTLET", 12, 2),
    SHIELD("SHIELD", 0, 10),
    NORNSTONES("NORNSTONES", 20, 0),
    ARMOUR("ARMOUR", 15, 1),
    ODINSWORD("ODINSWORD", 6, 1),
    NULLIFIER("NULLIFIER", 20, 6),
    ANTIGRAVITYGUN("ANTIGRAVITYGUN", 15, 2),
    CHITAURI_GUN("CHITAURI_GUN", 25, 1),
    BLASTER_GUN("BLASTER_GUN", 30, 0),
    WEB_SHOOTERS("WEB_SHOOTERS", 10, 20),
    ULTRA_SENTRIES("ULTRA_SENTRIES", 15, 10),
    FIRE_ARM("FIRE_ARM", 18, 0),
    BATTLE_FIELD_SUIT("BATTLE_FIELD_SUIT", 0, 40);

    public static final String TITLE = "\nChoose Weapon to fight";
    public static final String FOOTER_MESSAGE = "Please put operation number to select weapon";

    private final String name;
    private final int attackPower;
    private final int defencePower;

    Weapon(final String name, final int attackPower, final int defencePower) {
        this.name = name;
        this.attackPower = attackPower;
        this.defencePower = defencePower;
    }

    public static Weapon chooseRandom() {
        final Random random = new Random();
        final int randomValue = random.nextInt(values().length);
        final Weapon[] values = values();
        return values[randomValue];
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getDefencePower() {
        return defencePower;
    }

    @Override
    public String toString() {
        return name + '\'' +
                ", attackPower=" + attackPower +
                ", defencePower=" + defencePower;
    }
}
