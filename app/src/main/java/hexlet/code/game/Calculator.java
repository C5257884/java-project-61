package hexlet.code.game;

import hexlet.code.Cli;

public class Calculator extends Greet {
    private static final int MAX_VALUE = 100;
    private static final int NUMBER_OF_OPERATION = 3;

    public Calculator() {
        super("Calc");
    }

    @Override
    public void play() {

//        Welcome to the Brain Games!
//        May I have your name? Sam
//        Hello, Sam!
//        What is the result of the expression?
//        Question: 12 * 9
//        Your answer: 108
//        Correct!
//        Question: 17 + 10
//        Your answer: 27
//        Correct!
//        Question: 9 - 11
//        Your answer: -2
//        Correct!
//        Congratulations, Sam!
        super.play();
        System.out.println("What is the result of the expression?");

        var trueAnswerCount = 0;
        String answer;
        String correctAnswer;

        do {

            int operand1 = rand.nextInt(MAX_VALUE) + 1;
            int operand2 = rand.nextInt(MAX_VALUE) + 1;
            String operation = getOperation(rand.nextInt(NUMBER_OF_OPERATION));
            System.out.println("Question: " + operand1 + " " + operation + " " + operand2);

            answer = Cli.inputString("Your answer: ");
            correctAnswer = eval(operand1, operand2, operation);

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

    private String eval(int operand1, int operand2, String operation) {
        return switch (operation) {
            case "+" -> "" + (operand1 + operand2);
            case "-" -> "" + (operand1 - operand2);
            case "*" -> "" + (operand1 * operand2);
            default -> throw new IllegalStateException("Unexpected value: " + operation);
        };

    }

    private String getOperation(int i) {
        return switch (i) {
            case 0 -> "+";
            case 1 -> "-";
            case 2 -> "*";
            default -> throw new IllegalStateException("Unexpected value: " + i);
        };
    }
}
