package org.game.rpg.game.actions.start;

import org.game.rpg.game.actions.GameMode;
import org.game.rpg.game.map.GameLoader;
import org.game.rpg.game.map.GameLoaderImpl;
import org.game.rpg.game.map.operation.MapRepresentationManager;
import org.game.rpg.inventory.EntityManager;
import org.game.rpg.inventory.characterInventory.Character;
import org.game.rpg.inventory.characterInventory.hero.HeroType;
import org.game.rpg.inventory.characterInventory.villain.EnemyType;
import org.game.rpg.view.View;
import org.game.rpg.view.console.ConsoleMenu;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.game.rpg.inventory.characterInventory.CharacterInventory.getEnemy;
import static org.game.rpg.inventory.characterInventory.CharacterInventory.getHero;
import static org.game.rpg.util.GameUtil.getUserName;

/**
 * This method provide functionality to start a new game.
 *
 * Created by Amit Sharma on 3/14/2018.
 */
public class StartGame implements GameMode {

    public StartGame() {
        final Character userCharacter = createUser();
        initializeEntityManager(userCharacter, getEnemyList(5));
    }

    @Override
    public void action() {
        MapRepresentationManager.getInstance().initializeMapGrid();
        final GameLoader gameLoader = new GameLoaderImpl();
        gameLoader.loadGame();
    }

    private Character createUser() {
        final Character user = getHero(getCharacterType());
        user.setUserName(getUserName());
        return user;
    }

    private List<Character> getEnemyList(final int size) {
        final List<Character> enemies = new LinkedList<>();
        for (int counter = 0; counter < size; counter++) {
            final Character randomEnemy = getRandomEnemy(enemies);
            enemies.add(randomEnemy);
        }
        return enemies;
    }

    private Character getRandomEnemy(final List<Character> enemies) {
        final EnemyType enemyType = EnemyType.chooseRandom();
        final Optional<Character> optionalEnemy = enemies.stream().filter(e -> e.getName().equals(enemyType.getName())).findAny();
        if (optionalEnemy.isPresent()) {
            return getRandomEnemy(enemies);
        }
        return getEnemy(enemyType);
    }

    private HeroType getCharacterType() {
        final View<HeroType> heroTypeMenu = new ConsoleMenu<>(HeroType.TITLE, HeroType.FOOTER_MESSAGE, HeroType.values());
        return heroTypeMenu.readUserChoice();
    }

    private void initializeEntityManager(final Character userCharacter, List<Character> enemyList) {
        final EntityManager entityManager = EntityManager.getInstance();
        entityManager.addEntities(enemyList);
        entityManager.addEntity(userCharacter);
    }
}
