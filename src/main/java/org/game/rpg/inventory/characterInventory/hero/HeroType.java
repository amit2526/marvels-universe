package org.game.rpg.inventory.characterInventory.hero;

import org.game.rpg.inventory.weapons.Weapon;

import static java.lang.String.format;

public enum HeroType {
    SPIDERMAN("Spider Man", "SPI", 200, Weapon.WEB_SHOOTERS, Weapon.MJOLNIR, Weapon.GAUNTLET, Weapon.BATTLE_FIELD_SUIT, Weapon.BLASTER_GUN, Weapon.ULTRA_SENTRIES),
    BATMAN("Batman", "BAT", 250, Weapon.MJOLNIR, Weapon.SHIELD, Weapon.ODINSWORD, Weapon.NORNSTONES, Weapon.ARMOUR, Weapon.BATTLE_FIELD_SUIT),
    IROMMAN("Iron man", "IRO", 180, Weapon.MJOLNIR, Weapon.SHIELD, Weapon.ARMOUR, Weapon.NORNSTONES, Weapon.FIRE_ARM, Weapon.ULTRA_SENTRIES, Weapon.CHITAURI_GUN, Weapon.BLASTER_GUN, Weapon.ULTRA_SENTRIES),
    HULK("Hulk", "HUL", 280, Weapon.MJOLNIR, Weapon.SHIELD, Weapon.ODINSWORD, Weapon.NORNSTONES, Weapon.ANTIGRAVITYGUN, Weapon.ULTRA_SENTRIES),
    THOR("Thor", "THO", 150, Weapon.MJOLNIR, Weapon.ARMOUR, Weapon.ODINSWORD, Weapon.NULLIFIER, Weapon.FIRE_ARM, Weapon.BLASTER_GUN, Weapon.BATTLE_FIELD_SUIT, Weapon.CHITAURI_GUN, Weapon.CHITAURI_GUN);

    public static final String TITLE = "\nChoose Character";
    public static final String FOOTER_MESSAGE = "Please enter operation number";

    private final String name;
    private final String acronym;
    private final int health;
    private final Weapon[] weapons;

    HeroType(final String name, final String acronym, final int health, final Weapon... weapons) {
        this.name = name;
        this.acronym = acronym;
        this.health = health;
        this.weapons = weapons;
    }

    public String getName() {
        return name;
    }

    public String getAcronym() {
        return this.acronym;
    }

    public int getHealth() {
        return health;
    }

    public Weapon[] getWeapons() {
        return weapons;
    }

    @Override
    public String toString() {
        return format("%s (%s)", name, acronym);
    }
}
