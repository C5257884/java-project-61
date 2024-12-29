package hexlet.code.game;

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
    private String loopQuestion;

    public GCD() {
        super("GCD");
        setGameMainQuestion("Find the greatest common divisor of given numbers.");
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
     * Запрос ответа пользователя.
     * @return Наибольший Общий Делитель
     */
    @Override
    protected String inputActualAnswer() {

        System.out.println(loopQuestion);
        System.out.print("Your answer: ");
        return getInput().nextLine();
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
