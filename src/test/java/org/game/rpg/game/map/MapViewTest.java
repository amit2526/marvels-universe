package org.game.rpg.game.map;

import org.game.rpg.game.map.operation.MapRepresentationManager;
import org.game.rpg.inventory.EntityManager;
import org.game.rpg.inventory.characterInventory.Character;
import org.game.rpg.utils.TestUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.game.rpg.game.map.operation.MapRepresentationManager.HEALTH;
import static org.game.rpg.inventory.characterInventory.hero.HeroType.BATMAN;
import static org.game.rpg.inventory.characterInventory.villain.EnemyType.DOCTORDOOM;
import static org.game.rpg.inventory.characterInventory.villain.EnemyType.LOKI;

/**
 * Created by Amit Sharma on 3/15/2018.
 */
@RunWith(Parameterized.class)
public class MapViewTest {

    private MapRepresentationManager mapRepresentationManager;
    private MapView mapView;

    @Rule
    public SystemOutRule outRule = new SystemOutRule().enableLog();

    @Before
    public void setUp() {
        outRule.clearLog();
        this.mapRepresentationManager = MapRepresentationManager.getInstance();
        this.mapRepresentationManager.resetMapGrid();
        this.mapView = new ConsoleMapViewImpl();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return asList(new Object[] [] {
                {DOCTORDOOM.getAcronym()},
                {LOKI.getAcronym()},
                {HEALTH},
                {BATMAN.getAcronym()}
        });
    }

    @Parameterized.Parameter
    public String expectedEntityInMap;

    @After
    public void tearDown() {
        outRule.clearLog();
        this.mapRepresentationManager.resetMapGrid();
    }

    @Test
    public void viewMapTest() {
        //given
        List<Character> entities = TestUtil.prepareListOfEntities();
        EntityManager.getInstance().addEntities(entities);
        mapRepresentationManager.initializeMapGrid();

        //when
        mapView.displayMap(mapRepresentationManager.getMapRepresentation(), mapRepresentationManager.getMapGridSize());

        //then
        assertThat(outRule.getLog()).contains(expectedEntityInMap);
    }
}