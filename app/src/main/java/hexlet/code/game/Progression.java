package hexlet.code.game;

import hexlet.code.Cli;

import java.util.Random;

public class Progression extends Greet {
    private static final int LENGTH_OF_PROGRESSION = 10;

    private static class ArithmeticProgression {
        private static final int MAX_VALUE = 10;
        private final int firstMember;
        private final int commonDifference;

        ArithmeticProgression() {
            Random rand = new Random();
            firstMember = rand.nextInt(MAX_VALUE);
            commonDifference = rand.nextInt(MAX_VALUE);
        }

        public int getMember(int k) {
            return firstMember + (k - 1) * commonDifference;
        }
    }


    public Progression() {
        super("Progression");
    }

    @Override
    public void play() {

/*
    Welcome to the Brain Games!
    May I have your name? Sam
    Hello, Sam!
    What number is missing in the progression?
    Question: 5 7 9 11 13 .. 17 19 21 23
    Your answer: 15
    Correct!
    Question: 2 5 8 .. 14 17 20 23 26 29
    Your answer: 11
    Correct!
    Question: 14 19 24 29 34 39 44 49 54 ..
    Your answer: 59
    Correct!
    Congratulations, Sam!
*/
        super.play();
        System.out.println("What number is missing in the progression?");

        var trueAnswerCount = 0;
        int expMissMemberOfProgression;
        int actMissMemberOfProgression;
        int lengthOfProgression;
        int indexOfMissMember;

        do {
            lengthOfProgression = LENGTH_OF_PROGRESSION;
            indexOfMissMember = rand.nextInt(lengthOfProgression) + 1;

            // При каждом вопросе - нужен новый экземпляр
            var arithmeticProgression = new ArithmeticProgression();

            StringBuilder progressionStr = new StringBuilder();
            String delemiterStr = "";

            for (int i = 1; i <= lengthOfProgression; i++) {
                progressionStr.append(delemiterStr)
                    .append((i == indexOfMissMember) ? ".." : arithmeticProgression.getMember(i));
                delemiterStr = " ";
            }

            System.out.println("Question: " + progressionStr);

            actMissMemberOfProgression = Cli.inputIntNumber("Your answer: ");
            expMissMemberOfProgression = arithmeticProgression.getMember(indexOfMissMember);

            if (actMissMemberOfProgression == expMissMemberOfProgression) {
                trueAnswerCount++;
                System.out.println("Correct!");
            } else {
                trueAnswerCount = 0;
                break;
            }
        } while (trueAnswerCount < CORRECT_ANSWERS_THRESHOLD);

        endGameFlow(trueAnswerCount, "" + actMissMemberOfProgression, "" + expMissMemberOfProgression);
    }

}
