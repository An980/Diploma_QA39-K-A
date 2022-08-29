package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameStoreTest {
    GameStore store = new GameStore();
    @Test
    public void shouldAddGame() {
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    //22.08

    //===============================тесты для метода containsGame

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

    //===============================тесты для метода getSumPlayedTime

    @Test
    public void shouldSumTwoPlayerTime() {//суммирование времени 2х игроков

        GameStore store = new GameStore();

        store.addPlayTime("Player One", 10);
        store.addPlayTime("Player Two", 12);

        assertEquals(22, store.getSumPlayedTime());

    }

    @Test
    public void shouldSumZeroTime() {//суммирование нулевого времени

        GameStore store = new GameStore();

        store.addPlayTime("Player One", 0);
        store.addPlayTime("Player Two", 0);

        assertEquals(0, store.getSumPlayedTime());

    }

    @Test
    public void shouldSumSomePlayersTime() {//суммирование с нулевым временем включительно

        GameStore store = new GameStore();

        store.addPlayTime("Player One", 6);
        store.addPlayTime("Player Two", 1);
        store.addPlayTime("Player Three", 0);
        store.addPlayTime("Player Four", 4);

        assertEquals(11, store.getSumPlayedTime());

    }

    //===============================тесты для метода getMostPlayer

    @Test
    public void shouldShowPlayerMostTimePlayed() {//показ игрока с наибольшим временем игры

        GameStore store = new GameStore();

        store.addPlayTime("Player One", 4);
        store.addPlayTime("Player Two", 3);
        store.addPlayTime("Player Three", 2);
        store.addPlayTime("Player Four", 1);

        assertEquals("Player One", store.getMostPlayer());

    }

    @Test
    public void shouldShowPlayerZeroTime() {//ввод нулевых показателей времени (должен вернуть null)

        GameStore store = new GameStore();

        store.addPlayTime("Player One", 0);
        store.addPlayTime("Player Two", 0);

        assertEquals(null, store.getMostPlayer());

    }

    @Test
    public void shouldShowPlayerNegativeTime() {//отрицательные значения (должен вернуть null)

        GameStore store = new GameStore();

        store.addPlayTime("Player One", -1);

        assertEquals(null, store.getMostPlayer());

    }

    @Test
    public void shouldShowPlayerOneHour() {//показ игрока с наибольшим временем игры (должен вернуть null)

        GameStore store = new GameStore();

        store.addPlayTime("Player One", 1);

        assertEquals("Player One", store.getMostPlayer());

    }

    @Test
    public void shouldShowEmptyStore() {//показ пустого каталога игроков

        GameStore store = new GameStore();

        assertEquals(null, store.getMostPlayer());

    }


    @Test
    public void shouldShowSamePlayerTime() {//суммирование времени игроков

        GameStore store = new GameStore();

        store.addPlayTime("Player One", 5);
        store.addPlayTime("Player One", 7);
        store.addPlayTime("Player Two", 11);

        assertEquals("Player One", store.getMostPlayer());

    }

}
