package ru.netology;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void shouldSumGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());

        assertEquals(expected, actual);
    }
    @Test
    public void newGamesInstallation() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("Пэкмэн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.installGame(game1);
        player.play(game, 3);
        player.play(game1, 9);

        String expected3 = game1.getTitle();
        String actual3 = game.getTitle();

        assertEquals(expected3, actual3);
    }
    @Test
    public void maxPlayTimeByGenre() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Пэкмэн", "Аркады");
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.installGame(game1);
        player.play(game, 3);
        player.play(game1, 14);

        Game expected3 = player.mostPlayerByGenre("Аркады");
        String actual3 = game1.getTitle();

        assertEquals(expected3, actual3);

    }
    @Test
    public void ifNotInstalledThanRunTimeException() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Арканоид", "Strategy");
        Game game = store.publishGame("Дота", "Strategy");

        Player player = new Player("AndyScheglov");

        player.installGame(game);
        player.play(game, 3);

        assertThrows(RuntimeException.class, () -> player.play(game1, 12));
    }
    @Test
    public void PlayTimeForNotInstalledGame() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Арканоид", "Strategy");
        Game game = store.publishGame("Дота", "Strategy");

        Player player = new Player("AndyScheglov");

        player.play(game1, 8);
        player.play(game, 3);

        System.out.println(player.sumGenre("Strategy"));

        assertThrows(RuntimeException.class, () -> player.sumGenre("Strategy"));
    }
}
