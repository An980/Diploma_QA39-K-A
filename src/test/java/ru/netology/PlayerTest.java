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

        Game actual3 = player.mostPlayerByGenre("Аркады");
        Game expected3 = game1.getTitle();

        assertEquals(expected3, actual3);

    }
   
    @Test
    public void maxPlayTimeByGenre() {//изменил тест
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Пэкмэн", "Аркады");
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.installGame(game1);
        player.play(game, 3);
        player.play(game1, 14);

        Game expected3 = game1;
        Game actual3 = player.mostPlayerByGenre("Аркады");

        assertEquals(expected3, actual3);
    }

    @Test
    public void ifNotInstalledThanRunTimeException() {
        Player player = new Player("AndyScheglov");

        player.installGame(game);
        player.play(game, 3);

        assertThrows(RuntimeException.class, () -> player.play(game1, 12));
    }
    @Test //Игру скачали, не играли, максимум по жанру д.б. null
    public void NotPlayedNotCounted() {
        player.installGame(game2);

        Game expected = null;
        Game actual = player.mostPlayerByGenre("Экшн");
        assertEquals(expected, actual);
    }
    @Test //Суммирует время если в игру сыграли несколько раз
    public void PlayedMoreThanOnce() {
        player.installGame(game);

        player.play(game, 6);
        player.play(game, 12);

        int expected = 18;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    @Test //Игру скачали, но в нее не играли, счетчик должен быть 0
    public void GameNotPlayedButInstall() {

        player.installGame(game);

        int expected = 0;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }
}
