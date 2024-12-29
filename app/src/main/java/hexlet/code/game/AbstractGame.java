package hexlet.code.game;

import java.util.Random;
import java.util.Scanner;

//import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
abstract class AbstractGame implements Game {
    // Constants definition {
    private static final String GREET_MSG = "\nWelcome to the Brain Games!";
    private static final String INPUT_YOUR_NAME = "May I have your name?";
    private static final String HELLO_MSG = "Hello, ";
    protected static final int MAX_VALUE = 100;
    protected static final int CORRECT_ANSWERS_THRESHOLD = 3;
    // Constants definition }

    /**
     * Текст основного вопроса игры.
     */
    @Getter
    private String gameMainQuestion;
    //@Getter(AccessLevel.PROTECTED)
    protected final Random rand;
//    @Getter
    private final String title;
    @Getter
    private String userName;

    protected Scanner input;

    AbstractGame(String gameTitle) {
        title = gameTitle;
        rand = new Random();
        input = new Scanner(System.in);
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
        String actualAnswer;
        String correctAnswer;

        handShake();

        // Output main question of the Game
        System.out.println(gameMainQuestion);

        var trueAnswerCount = 0;

        do {
            generateGameParams();
            actualAnswer = inputActualAnswer();
            correctAnswer = getCorrectAnswer();

            if (actualAnswer.equals(correctAnswer)) {
                trueAnswerCount++;
                System.out.println("Correct!");
            } else {
                trueAnswerCount = 0;
                break;
            }
        } while (trueAnswerCount < CORRECT_ANSWERS_THRESHOLD);

        if (trueAnswerCount == CORRECT_ANSWERS_THRESHOLD) {
            System.out.println("Congratulations, " + userName + "!");
        } else {
            System.out.println("'" + actualAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer
                + "'\nLet's try again, " + userName + "!");
        }
    }

    /**
     * Greeting the user and ask for their name.
     */
    protected void handShake() {
        System.out.println(GREET_MSG);
        System.out.print(INPUT_YOUR_NAME);

        userName = input.nextLine();
        System.out.println(HELLO_MSG + userName + "!");
    }

    @Override
    public String getDescription() {
        return title;
    }
}
