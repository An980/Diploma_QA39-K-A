package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameStoreTest {

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    // другие ваши тесты

    //22.08

    @Test
    public void shouldAddSomeGames() {//добавить несколько игр
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Пазл", "Пазлы");
        Game game2 = store.publishGame("Футбол", "Спортивные");
        Game game3 = store.publishGame("Кодзима гений!", "Квесты");
        Game game4 = store.publishGame("Шутер", "Аркады");
        Game game5 = store.publishGame("Жадный Гейб", "Экономические");

        assertTrue(store.containsGame(game1));
        assertTrue(store.containsGame(game2));
        assertTrue(store.containsGame(game3));
        assertTrue(store.containsGame(game4));
        assertTrue(store.containsGame(game5));

    }

    @Test
    public void shouldNotAddEmptyParams() {//ничего не добавить
        GameStore store = new GameStore();
//        Game game1 = store.publishGame("Пазл", "Пазлы");
//        Game game2 = store.publishGame("Футбол", "Спортивные");
//        Game game3 = store.publishGame("Кодзима гений!", "Квесты");
//        Game game4 = store.publishGame("Шутер", "Аркады");
//        Game game5 = store.publishGame("Жадный Гейб", "Экономические");

        assertFalse(store.containsGame(null));
    }

    @Test
    public void shouldSumTwoPlayerTime() {//суммирование времени 2х игроков

        GameStore store = new GameStore();

        store.addPlayTime("Player One", 10);
        store.addPlayTime("Player Two", 12);

        Assertions.assertEquals(12, store.getSumPlayedTime());

    }

    @Test
    public void shouldSumZeroTime() {//суммирование нулевого времени

        GameStore store = new GameStore();

        store.addPlayTime("Player One", 0);
        store.addPlayTime("Player Two", 0);

        Assertions.assertEquals(0, store.getSumPlayedTime());

    }

    @Test
    public void shouldSumSomePlayersTime() {//суммирование нулевого времени

        GameStore store = new GameStore();

        store.addPlayTime("Player One", 6);
        store.addPlayTime("Player Two", 1);
        store.addPlayTime("Player Three", 0);
        store.addPlayTime("Player Four", 4);

        Assertions.assertEquals(11, store.getSumPlayedTime());

    }

}
