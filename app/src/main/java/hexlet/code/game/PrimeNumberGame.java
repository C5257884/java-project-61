package hexlet.code.game;

import hexlet.code.Cli;

public class PrimeNumberGame extends Greet {
    private static final int MAX_VALUE = 100;
    private static final int CORRECT_ANSWERS_THRESHOLD = 3;

    public PrimeNumberGame(int gameHotPoint) {
        super(gameHotPoint, "Prime");
    }

    @Override
    public void play() {

/*
    Welcome to the Brain Games!
    May I have your name? Sam
    Hello, Sam!
    Answer 'yes' if given number is prime. Otherwise answer 'no'.
    Question: 7
    Your answer: yes
    Correct!
*/

        super.play();
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        var trueAnswerCount = 0;
        String answer;
        String correctAnswer;


        do {

            int number = rand.nextInt(MAX_VALUE) + 1;

            System.out.println("Question: " + number);

            answer = Cli.inputString("Your answer (yes/no): ");
            correctAnswer = (isPrime(number)) ? "yes" : "no";

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
