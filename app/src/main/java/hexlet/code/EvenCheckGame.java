package hexlet.code;

import java.util.Random;

public class EvenCheckGame extends Greet {
    private static final int MAX_VALUE = 100;
    private static final int CORRECT_ANSWERS_THRESHOLD = 3;

    EvenCheckGame(int gameHotPoint) {
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

        Random rand = new Random();

        var trueAnswerCount = 0;
        String answer;
        String correctAnswer;

        do {

            int number = rand.nextInt(MAX_VALUE) + 1;
            System.out.println("Question: " + number);

            answer = Cli.getUserName("Your answer (yes/no): ");

            correctAnswer = (number % 2 == 0) ? "yes" : "no";

            if (answer.equals(correctAnswer)) {
                trueAnswerCount++;
                System.out.println("Correct!");
            } else {
                var info = "'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer
                    + "'\nLet's try again, " + userName + "!";
                System.out.println(info);
                trueAnswerCount = 0;
            }
        } while (trueAnswerCount < CORRECT_ANSWERS_THRESHOLD && answer.equals(correctAnswer));

        if (trueAnswerCount == CORRECT_ANSWERS_THRESHOLD) {
            System.out.println("Congratulations, " + userName + "!");
        }
    }
}
