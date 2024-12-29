package hexlet.code.game;

import java.util.Random;
import java.util.Scanner;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
abstract class AbstractGame implements Game {
    // Constants definition {
    protected static final int MAX_VALUE = 100;
    protected static final int CORRECT_ANSWERS_THRESHOLD = 3;
    // Constants definition }

    /**
     * Текст основного вопроса игры.
     */
    private String gameMainQuestion;
    @Getter(AccessLevel.PROTECTED)
    private final Random rand;
    private final String title;
    private Scanner input;

    AbstractGame(String gameTitle, Scanner inputScaner) {
        title = gameTitle;
        rand = new Random();
        this.input = inputScaner;
    }

    /**
     * Определение <правильного ответа> для текущщей игры.
     *
     * @return the line - correct answer
     */
    protected abstract String getCorrectAnswer();

    /**
     * Запрос ответа пользователя.
     *
     * @return the line - user answer
     */
    protected abstract String inputActualAnswer();

    /**
     * Установка центральных условий/параметров игры.
     */
    protected abstract void generateGameParams();

    @Override
    public void play() {

        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name?");
        var userName = input.nextLine();
        System.out.println("Hello, " + userName + "!");

        // Output main question of the Game
        System.out.println(gameMainQuestion);

        var trueAnswerCount = 0;

        do {
            generateGameParams();
            var actualAnswer = inputActualAnswer();
            var correctAnswer = getCorrectAnswer();

            if (actualAnswer.equals(correctAnswer)) {
                trueAnswerCount++;
                System.out.println("Correct!");
            } else {
                System.out.println("'" + actualAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer
                    + "'\nLet's try again, " + userName + "!");
                return;
            }
        } while (trueAnswerCount < CORRECT_ANSWERS_THRESHOLD);

        System.out.println("Congratulations, " + userName + "!");
    }

    /**
     * Method return Game description.
     * @return game description
     */
    @Override
    public String getDescription() {
        return title;
    }
}
