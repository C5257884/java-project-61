package hexlet.code.game;

import java.util.Scanner;

/**
 * Game Scenario.
 * <p>
 * Welcome to the Brain Games!
 * May I have your name? Sam
 * Hello, Sam!
 * Answer 'yes' if given number is prime. Otherwise answer 'no'.
 * Question: 7
 * Your answer: yes
 * Correct!
 */
public final class PrimeNumber extends AbstractGame {
    private int centralGameNumber;

    /**
     * CONSTRUCTOR.
     * @param input - object Scaner
     */
    public PrimeNumber(Scanner input) {
        super("Prime", input);
        setGameMainQuestion("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
    }

    /**
     * Устанавливает случаным образом число для игры.
     * Данное число либо ПРОСТОЕ (делится на 1 и само себя),<br/>
     * либо - нет, пользователю нужно это определить и дать правильный ответ
     */
    @Override
    protected void generateGameParams() {
        centralGameNumber = getRand().nextInt(MAX_VALUE) + 1;
    }

    /**
     * Запрос ответа пользователя на вопрос, четное или нет число.
     *
     * @return Введенный пользователем ответ "yes/no"
     */
    @Override
    protected String inputActualAnswer() {

        System.out.println("Question: " + centralGameNumber);
        System.out.print("Your answer (yes/no): ");
        return getInput().nextLine();
    }

    /**
     * Определение четности числа и возврат ответа.
     * Возвращенный ответ будет сравниваться с ответом введенным пользователем
     *
     * @return Четное или нет число "yes/no"
     */
    @Override
    protected String getCorrectAnswer() {
        return (isPrime(centralGameNumber)) ? "yes" : "no";
    }

    /**
     * Определение простое число или нет.
     *
     * @param n - Число
     * @return true/false
     */
    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(n) + 1; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
