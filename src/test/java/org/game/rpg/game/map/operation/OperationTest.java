package org.game.rpg.game.map.operation;

import org.game.rpg.game.map.operation.Operation.OperationType;
import org.game.rpg.inventory.EntityManager;
import org.game.rpg.inventory.characterInventory.Character;
import org.game.rpg.inventory.characterInventory.CharacterInventory;
import org.game.rpg.inventory.characterInventory.hero.HeroType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.awt.*;
import java.util.Collection;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.game.rpg.game.map.operation.Operation.OperationType.*;
import static org.game.rpg.inventory.characterInventory.hero.HeroType.IROMMAN;

/**
 * Created by Amit Sharma on 3/16/2018.
 */
@RunWith(Parameterized.class)
public class OperationTest {

    private MapRepresentationManager movement;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return asList(new Object[] [] {
                {RIGHT, 2, 3},
                {LEFT, 2, 1},
                {UP, 1, 2},
                {DOWN, 3, 2}
        });
    }

    @Parameterized.Parameter
    public OperationType operationType;

    @Parameterized.Parameter(1)
    public int x;

    @Parameterized.Parameter(2)
    public int y;

    @Before
    public void setUp() {
        movement = MapRepresentationManager.getInstance();
        EntityManager.getInstance().removeAllEntities();
        movement.resetMapGrid();
    }

    @After
    public void tearDown() {
        EntityManager.getInstance().removeAllEntities();
        movement.resetMapGrid();
    }

    @Test
    public void performOperationTest() throws Exception {
        //given
        final Character hero = getHero(IROMMAN);
        EntityManager.getInstance().addEntity(hero);
        movement.initializeMapGrid();

        //when
        OperationContext.getInstance(movement).executeOperation(hero, operationType);

        //then
        assertThat(hero.position().getX()).isEqualTo(x);
        assertThat(hero.position().getY()).isEqualTo(y);
    }

    static Character getHero(HeroType heroType) {
        final Character user = CharacterInventory.getHero(heroType);
        user.setPosition(new Point(2,2));
        return user;
    }
}