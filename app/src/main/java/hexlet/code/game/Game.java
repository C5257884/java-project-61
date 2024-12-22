package hexlet.code.game;

/**
 * Интерфейс <Game> для предоставления функциональности <Игры>.
 */
public interface Game {

    /**
     * Возвращает описание игры.
     * @return строка-описание
     */
    String getDescription();

    /**
     * Запускает игру.
     */
    void play();
}
