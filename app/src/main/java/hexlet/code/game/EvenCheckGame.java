package hexlet.code.game;

import hexlet.code.Cli;

public class EvenCheckGame extends Greet {
    private static final int MAX_VALUE = 100;
    private static final int CORRECT_ANSWERS_THRESHOLD = 3;

    public EvenCheckGame(int gameHotPoint) {
        super(gameHotPoint, "Even");
    }

    @Override
    public void play() {

//        Welcome to the Brain Games!
//        May I have your name? Bill
//        Hello, Bill!
//        Answer 'yes' if the number is even, otherwise answer 'no'.
//        Question: 15
//        Your answer: yes
//        ##В случае, если пользователь даст неверный ответ, необходимо завершить игру и вывести сообщение:
//        'yes' is wrong answer ;(. Correct answer was 'no'.
//        Let's try again, Bill!
//        ##В случае, если пользователь ввел верный ответ, нужно отобразить:
//        Correct!
//        ##и приступить к следующему числу.
//        ##Пользователь должен дать правильный ответ на три вопроса подряд. После успешной игры нужно вывести:
//        Congratulations, Bill!
        super.play();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        var trueAnswerCount = 0;
        String answer;
        String correctAnswer;

        do {

            int number = rand.nextInt(MAX_VALUE) + 1;
            System.out.println("Question: " + number);

            answer = Cli.inputString("Your answer (yes/no): ");
            correctAnswer = (number % 2 == 0) ? "yes" : "no";

            if (answer.equals(correctAnswer)) {
                trueAnswerCount++;
                System.out.println("Correct!");
            } else {
                trueAnswerCount = 0;
                break;
            }
        } while (trueAnswerCount < CORRECT_ANSWERS_THRESHOLD);

        endGameFlow(trueAnswerCount, answer, correctAnswer);
    }
}
