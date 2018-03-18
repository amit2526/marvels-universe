package org.game.rpg.game.map.operation;

import org.game.rpg.inventory.characterInventory.Character;

public interface Operation {

    void performOperation(final Character user);

    enum OperationType {
        RIGHT("Move Right"),
        LEFT("Move Left"),
        UP("Move Up"),
        DOWN("Move Down"),
        SAVE("Save"),
        EXIT("Exit");

        private final String name;

        OperationType(final String name) {
            this.name = name;
        }

        public static final String TITLE = "Explore";
        public static final String FOOTER_MESSAGE = "Please put operation number";

        @Override
        public String toString() {
            return name;
        }
    }
}
