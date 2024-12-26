package hexlet.code.game;

public class EvenCheck extends AbstractGame {
    private int centralGameNumber;

    public EvenCheck() {
        super("Even");
        gameMainQuestion = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    @Override
    protected void generateGameParams() {
        centralGameNumber = getRand().nextInt(MAX_VALUE) + 1;
    }

    @Override
    protected String inputActalAnswer() {

        System.out.println("Question: " + centralGameNumber);
        System.out.print("Your answer (yes/no): ");
        return input.nextLine();
    }

    @Override
    protected String getCorrectAnswer() {
        return (centralGameNumber % 2 == 0) ? "yes" : "no";
    }

    /**
     * Game Scenario.
     * <p>
     * Welcome to the Brain Games!
     * May I have your name? Bill
     * Hello, Bill!
     * Answer 'yes' if the number is even, otherwise answer 'no'.
     * Question: 15
     * Your answer: yes
     * ##В случае, если пользователь даст неверный ответ, необходимо завершить игру и вывести сообщение:
     * 'yes' is wrong answer ;(. Correct answer was 'no'.
     * Let's try again, Bill!
     * ##В случае, если пользователь ввел верный ответ, нужно отобразить:
     * Correct!
     * ##и приступить к следующему числу.
     * ##Пользователь должен дать правильный ответ на три вопроса подряд. После успешной игры нужно вывести:
     * Congratulations, Bill!
     */
    @Override
    public final void play() {
        super.play();
    }
}
