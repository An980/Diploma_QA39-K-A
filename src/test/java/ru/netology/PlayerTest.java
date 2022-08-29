package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PlayerTest {
    GameStore store = new GameStore();
    Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
    Game game1 = store.publishGame("Пэкмэн", "Аркады");
    Game game2 = store.publishGame("Арканоид", "Экшн");
    Game game3 = store.publishGame("Дота", "Стратегия");

    Player player = new Player("Petya");
    @Test   // Время суммируется даже если в жанре есть только одна игра
    public void shouldSumGenreIfOneGame() {
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());

        assertEquals(expected, actual);
    }

    @Test //Выдача игры из жанра, в которую играли больше всего времени
    public void maxPlayTimeByGenre() {
        player.installGame(game);
        player.installGame(game1);
        player.play(game, 3);
        player.play(game1, 14);

        Game expected3 = game1;
        Game actual3 = player.mostPlayerByGenre("Аркады");

        assertEquals(expected3, actual3);
    }

    @Test //Если игра не установлена, то выдача Run-time exception
    public void ifNotInstalledThanRunTimeException() {
        player.installGame(game3);
        player.play(game3, 3);

        assertThrows(RuntimeException.class, () -> player.play(game2, 12));
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
