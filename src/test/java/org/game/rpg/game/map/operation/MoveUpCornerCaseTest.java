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
import static org.game.rpg.game.map.operation.Operation.OperationType.LEFT;
import static org.game.rpg.game.map.operation.Operation.OperationType.UP;
import static org.game.rpg.inventory.characterInventory.hero.HeroType.THOR;

/**
 * Created by Amit Sharma on 3/16/2018.
 */
public class MoveUpCornerCaseTest {

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
    public void performUpOperation_WhenUserCantGoUp() {
        this.user.setPosition(new Point(0, 0));
        new MoveUp().performOperation(user);

        assertThat(outRule.getLog())
                .contains(format(MapRepresentationManager.CANT_MOVE_MESSAGE, UP.name()));

        assertThat(user.position().getX()).isEqualTo(0);
        assertThat(user.position().getY()).isEqualTo(0);
    }

    @Test
    public void performRightOperation_WhenUserFindHealth() {
        //given
        this.user.setPosition(new Point(4, 4));
        this.mapRepresentationManager.setMapRepresentation(prepareGrid());
        new MoveUp().performOperation(user);

        assertThat(outRule.getLog())
                .contains(format("Congratulations!! Your health Increases by 50."));

        assertThat(user.position().getX()).isEqualTo(3);
        assertThat(user.position().getY()).isEqualTo(4);
    }

    private String[][] prepareGrid() {
        final String[][] map = new String[mapRepresentationManager.getMapGridSize()][mapRepresentationManager.getMapGridSize()];
        map[3][4] = "<"+ MapRepresentationManager.HEALTH+">";
        return map;
    }
}