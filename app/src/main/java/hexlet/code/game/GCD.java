package hexlet.code.game;

import java.util.Scanner;

/**
 * Game Scenario.
 * <p>
 * Welcome to the Brain Games!
 * May I have your name? Sam
 * Hello, Sam!
 * Find the greatest common divisor of given numbers.
 * Question: 25 50
 * Your answer: 25
 * Correct!
 * Question: 100 52
 * Your answer: 4
 * Correct!
 * Question: 3 9
 * Your answer: 3
 * Correct!
 * Congratulations, Sam!
 */
public class GCD extends AbstractGame {
    private int operand1;
    private int operand2;
//    private String loopQuestion;

    public GCD(Scanner input) {
        super("GCD", input);
        setGameMainQuestion("Find the greatest common divisor of given numbers.");
        tipQuestion = "Your answer: ";
    }

    /**
     * Устанавливает случаным образом числа для игры.
     * Пользователю нужно найти Наибольший Общий Делитель<br/>
     * для данных чисел и дать правильный ответ
     */
    @Override
    protected void generateGameParams() {
        operand1 = getRand().nextInt(MAX_VALUE) + 1;
        operand2 = getRand().nextInt(MAX_VALUE) + 1;
        loopQuestion = "Question: " + operand1 + " " + operand2;
    }

    /**
     * Определение четности числа и возврат ответа.
     * Возвращенный ответ будет сравниваться с ответом введенным пользователем
     * @return Четное или нет число "yes/no"
     */
    @Override
    protected String getCorrectAnswer() {
        return "" + evalGDC(operand1, operand2);
    }

    /**
     * Вычисление НОД (Наибольший Общий Делитель).
     * @param val1 - число
     * @param val2 - число
     * @return GDC(val1, val2)
     */
    private int evalGDC(int val1, int val2) {
        int num1 = val1;
        int num2 = val2;
        int temp;

        while (num2 != 0) {
            temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }
}
