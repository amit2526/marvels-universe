package org.game.rpg.game.map;

import org.game.rpg.view.console.TickerView;

import static java.lang.System.out;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Stream.generate;
import static org.game.rpg.game.map.operation.MapRepresentationManager.PADDING;

/**
 * This class provide functionality to view map on console.
 *
 * Created by Amit Sharma on 3/14/2018.
 */
public class ConsoleMapViewImpl implements MapView {

    private static final String PIPE = "|";
    private static final String NEWLINE = "\n";
    private static final int MAP_SIZE_MARGIN = 6;

    @Override
    public void displayMap(final String[][] grid, final int gridSize) {
        printHLine(gridSize);
        for (int i = 0; i < gridSize; i++) {
            out.print(PIPE);
            for (int j = 0; j < gridSize; j++) {
                printGrid(grid[i][j]);
            }
            out.print(PIPE + NEWLINE);
        }
        printHLine(gridSize);
        printFooterLine();
    }

    private void printFooterLine() {
        TickerView.displayTicker("'<< >>' represent Health, '<...>' represent Enemy, '>...<' represent User");
    }

    private void printGrid(final String str) {
        if (str == null || str.isEmpty()) {
            out.print(PADDING);
        } else {
            out.print(str);
        }
    }

    private void printHLine(final int gridSize) {
        out.println(
                generate(() -> "-").limit(gridSize * MAP_SIZE_MARGIN).collect(joining())
        );
    }
}
