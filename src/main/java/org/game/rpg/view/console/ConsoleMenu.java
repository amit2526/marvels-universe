package org.game.rpg.view.console;

import org.game.rpg.view.View;

import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;
import static java.lang.System.out;
import static java.util.stream.Collectors.toList;

/**
 * This class is a console based implementation of {@link View} for displaying menu & options on console and read user inputs from console.
 *
 * Created by Amit Sharma on 3/14/2018.
 */
public class ConsoleMenu<T> implements View<T> {
    private String title;
    private String promptMessage;
    private List<T> items;
    private BiPredicate<Integer, List<T>> LIES_IN_MENU_RANGE = (choice, menuItems) -> choice > 0 && choice <= menuItems.size();
    private Predicate<String> IS_NUMERIC = charSequence -> {
        if(charSequence.isEmpty()) {
            return false;
        }
        final int size = charSequence.length();
        for (int i = 0; i < size; i++) {
            if (!Character.isDigit(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    };

    @SafeVarargs
    public ConsoleMenu(final String title, final String promptMessage, final T... items) {
        this.title = title;
        this.promptMessage = promptMessage;
        this.items = Stream.of(items).collect(toList());
    }

    public T readUserChoice() {
        displayMenu();
        return getUserChoice();
    }

    public String readInputString() {
        displayMenu();
        return getUserName();
    }

    private T getUserChoice() {
        Scanner scanner = new Scanner(System.in, "UTF-8");

        String line = scanner.nextLine();
        if (IS_NUMERIC.test(line)) {
            int choice = parseInt(line);
            if (LIES_IN_MENU_RANGE.test(choice, items)) {
                return items.get(choice-1);
            }
        }
        out.println("Incorrect choice! Please enter a correct choice");
        return readUserChoice();
    }

    private String getUserName() {
        final Scanner scanner = new Scanner(System.in, "UTF-8");
        String line = scanner.nextLine();
        if (!IS_NUMERIC.test(line)) {
            return line;
        }
        out.println("Incorrect Name! Please enter a correct user name");
        return getUserName();
    }

    public void displayMenu() {
        out.println(title.toUpperCase());
        IntStream.rangeClosed(1, items.size())
                .mapToObj(this::formatToItem)
                .forEach(this::print);
        out.println(promptMessage);
    }

    private String formatToItem(final int i) {
        return String.format("%2s. %s", i, items.get(i - 1).toString());
    }

    private void print(final String message) {
        out.println(message);
    }
}