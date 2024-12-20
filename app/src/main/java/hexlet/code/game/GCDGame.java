package hexlet.code.game;

import hexlet.code.Cli;

public class GCDGame extends Greet {
    private static final int MAX_VALUE = 100;


    public GCDGame(int gameHotPoint) {
        super(gameHotPoint, "GCD");
    }

    @Override
    public void play() {

/*
        Welcome to the Brain Games!
        May I have your name? Sam
        Hello, Sam!
        Find the greatest common divisor of given numbers.
        Question: 25 50
        Your answer: 25
        Correct!
        Question: 100 52
        Your answer: 4
        Correct!
        Question: 3 9
        Your answer: 3
        Correct!
        Congratulations, Sam!
*/
        super.play();
        System.out.println("Find the greatest common divisor of given numbers.");

        var trueAnswerCount = 0;
        int expGDC;
        int actGDC;

        do {

            int operand1 = rand.nextInt(MAX_VALUE) + 1;
            int operand2 = rand.nextInt(MAX_VALUE) + 1;
            System.out.println("Question: " + operand1 + " " + operand2);

            actGDC = Cli.inputIntNumber("Your answer: ");
            expGDC = evalGDC(operand1, operand2);

            if (actGDC == expGDC) {
                trueAnswerCount++;
                System.out.println("Correct!");
            } else {
                trueAnswerCount = 0;
                break;
            }
        } while (trueAnswerCount < CORRECT_ANSWERS_THRESHOLD);

        endGameFlow(trueAnswerCount, "" + actGDC, "" + expGDC);
    }

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
