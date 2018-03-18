package org.game.rpg.game.map;

import org.game.rpg.exception.ExitGameException;
import org.game.rpg.inventory.EntityManager;
import org.game.rpg.inventory.characterInventory.Character;
import org.game.rpg.inventory.characterInventory.CharacterInventory;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.rules.ExpectedException;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.game.rpg.inventory.EntityManager.getInstance;
import static org.game.rpg.inventory.characterInventory.CharacterInventory.getHero;
import static org.game.rpg.inventory.characterInventory.hero.HeroType.SPIDERMAN;
import static org.game.rpg.inventory.characterInventory.villain.EnemyType.REDSKULL;

public class GameLoaderImplTest {

    private GameLoader gameLoader;
    private Character user;

    @Rule
    public SystemOutRule outRule = new SystemOutRule().enableLog();

    @Rule
    public ExpectedSystemExit systemExit = ExpectedSystemExit.none();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @After
    public void tearDown() throws Exception {
        System.setIn(System.in);
        EntityManager.getInstance().removeAllEntities();
    }

    @Test
    public void initializeGameLoadImpl_WithoutSettingUser() {
        expectedException.expect(ExitGameException.class);
        expectedException.expectMessage("Unable to find User");

        //when creating GameLoaderImpl object
        this.gameLoader = new GameLoaderImpl();
    }

    @Test
    public void loadGameTest_WhenThereIsNoEnemyLeft() {
        //when
        this.user = createTestUser(true);
        this.gameLoader = initializeGameLoader(Collections.singletonList(user));

        final InputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        systemExit.expectSystemExitWithStatus(1);

        //when
        this.gameLoader.loadGame();

        //then
        assertThat(outRule.getLog()).contains("You Win!!");
    }

    @Test
    public void loadGameTest_WhenUserHealthIsZero() {
        //given
        this.user = createTestUser(false);
        addEnemy();
        this.gameLoader = initializeGameLoader(Collections.singletonList(user));

        final InputStream in = new ByteArrayInputStream("2".getBytes());
        System.setIn(in);
        systemExit.expectSystemExitWithStatus(1);

        //when
        this.gameLoader.loadGame();

        //then
        assertThat(outRule.getLog()).contains("Game Over");
    }

    private void addEnemy() {
        final Character enemy = CharacterInventory.getEnemy(REDSKULL);
        enemy.setPosition(new Point(5,5));
        getInstance().addEntity(enemy);
    }

    private Character createTestUser(boolean isHealthRequired) {
        final Character user = getHero(SPIDERMAN);
        user.setPosition(new Point(0,0));
        user.setUserName("Test-loadGame");
        if (!isHealthRequired) {
            user.decreaseHealth(user.health());
        }
        return user;
    }

    private GameLoader initializeGameLoader(final List<Character> entities) {
        getInstance().addEntities(entities);
        return new GameLoaderImpl();
    }
}