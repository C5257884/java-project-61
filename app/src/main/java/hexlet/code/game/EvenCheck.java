package hexlet.code.game;

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
     */
    public EvenCheck() {
        super("Even");
        setGameMainQuestion("Answer 'yes' if the number is even, otherwise answer 'no'.");
    }

    /**
     * Устанавливает случаным образом число для игры.
     * Данное число либо четное, либо - нет, пользователю нужно это определить
     * и дать правильный ответ
     */
    @Override
    protected void generateGameParams() {
        centralGameNumber = getRand().nextInt(MAX_VALUE) + 1;
    }

    /**
     * Запрос ответа пользователя на вопрос, четное или нет число.
     * @return Введенный пользователем ответ "yes/no"
     */
    @Override
    protected String inputActualAnswer() {

        System.out.println("Question: " + centralGameNumber);
        System.out.print("Your answer (yes/no): ");
        return input.nextLine();
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
