package org.game.rpg.game.actions.resume;

import org.game.rpg.game.actions.GameMode;
import org.game.rpg.game.actions.util.ActionUtil;
import org.game.rpg.game.map.GameLoaderImpl;
import org.game.rpg.game.map.operation.MapRepresentationManager;
import org.game.rpg.inventory.EntityManager;
import org.game.rpg.inventory.characterInventory.Character;
import org.game.rpg.persistance.FilePersistence;
import org.game.rpg.persistance.Persistence;

import java.util.List;

import static java.util.Objects.nonNull;
import static org.game.rpg.util.GameUtil.getUserName;

/**
 * This class provides functionality to users to load previously saved game.
 *
 * Created by Amit Sharma on 3/14/2018.
 */
public class ResumeGame implements GameMode {

    @Override
    public void action() {
        final String userName = getUserName();
        final Persistence persistence = new FilePersistence();
        final List<Character> entities = persistence.load(userName);

        if (nonNull(entities)) {
            final EntityManager entityManager = EntityManager.getInstance();
            entityManager.addEntities(entities);

            MapRepresentationManager.getInstance().initializeMapGrid();

            new GameLoaderImpl().loadGame();
        } else {
            ActionUtil.viewPostActions();
        }
    }
}

