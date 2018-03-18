package org.game.rpg.game.map.operation;

import org.game.rpg.inventory.characterInventory.Character;
import org.game.rpg.inventory.characterInventory.CharacterInventory;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.awt.*;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.game.rpg.game.map.operation.Operation.OperationType.DOWN;
import static org.game.rpg.inventory.characterInventory.hero.HeroType.THOR;

/**
 * Created by Amit Sharma on 3/16/2018.
 */
public class MoveDownCornerCaseTest {

    private MapRepresentationManager mapRepresentationManager;
    private Character user;

    @Rule
    public SystemOutRule outRule = new SystemOutRule().enableLog();

    @Before
    public void setUp() {
        this.mapRepresentationManager = MapRepresentationManager.getInstance();
        this.mapRepresentationManager.resetMapGrid();
        this.user = CharacterInventory.getHero(THOR);
    }

    @After
    public void tearDown() {
        this.mapRepresentationManager.resetMapGrid();
    }

    @Test
    public void performDownOperation_WhenUserCantGoDown() {
        this.user.setPosition(new Point(5, 5));
        new MoveDown().performOperation(user);

        assertThat(outRule.getLog())
                .contains(format(MapRepresentationManager.CANT_MOVE_MESSAGE, DOWN.name()));

        assertThat(user.position().getX()).isEqualTo(5);
        assertThat(user.position().getY()).isEqualTo(5);
    }

    @Test
    public void performDownOperation_WhenUserFindHealth() {
        //given
        this.user.setPosition(new Point(1, 1));
        this.mapRepresentationManager.setMapRepresentation(prepareGrid());
        new MoveDown().performOperation(user);

        assertThat(outRule.getLog())
                .contains(format("Congratulations!! Your health Increases by 50."));

        assertThat(user.position().getX()).isEqualTo(2);
        assertThat(user.position().getY()).isEqualTo(1);
    }

    private String[][] prepareGrid() {
        final String[][] map = new String[mapRepresentationManager.getMapGridSize()][mapRepresentationManager.getMapGridSize()];
        map[2][1] = "<"+ MapRepresentationManager.HEALTH+">";
        return map;
    }
}