package hexlet.code.game;

import java.util.Scanner;

/**
 * Game Scenario.
 * <p>
 * Welcome to the Brain Games!<br/>
 * May I have your name? Bill<br/>
 * Hello, Bill!<br/>
 * Answer 'yes' if the number is even, otherwise answer 'no'.<br/>
 * Question: 15<br/>
 * Your answer: yes<br/>
 * ##В случае, если пользователь даст неверный ответ, необходимо завершить игру и вывести сообщение:<br/>
 * 'yes' is wrong answer ;(. Correct answer was 'no'.<br/>
 * Let's try again, Bill!<br/>
 * ##В случае, если пользователь ввел верный ответ, нужно отобразить:<br/>
 * Correct!<br/>
 * ##и приступить к следующему числу.<br/>
 * ##Пользователь должен дать правильный ответ на три вопроса подряд. После успешной игры нужно вывести:<br/>
 * Congratulations, Bill!<br/>
 */
public final class EvenCheck extends AbstractGame {
    private int centralGameNumber;

    /**
     * CONSTRUCTOR.
     * @param input - object Scaner
     */
    public EvenCheck(Scanner input) {
        super("Even", input);
        setGameMainQuestion("Answer 'yes' if the number is even, otherwise answer 'no'.");
        setTipQuestion("Your answer (yes/no): ");
    }

    /**
     * Устанавливает случаным образом число для игры.
     * Данное число либо четное, либо - нет, пользователю нужно это определить
     * и дать правильный ответ
     */
    @Override
    protected void generateGameParams() {
        centralGameNumber = getRand().nextInt(MAX_VALUE) + 1;
        setLoopQuestion("Question: " + centralGameNumber);
    }

    /**
     * Определение четности числа и возврат ответа.
     * Возвращенный ответ будет сравниваться с ответом введенным пользователем
     * @return Четное или нет число "yes/no"
     */
    @Override
    protected String getCorrectAnswer() {
        return (centralGameNumber % 2 == 0) ? "yes" : "no";
    }
}
