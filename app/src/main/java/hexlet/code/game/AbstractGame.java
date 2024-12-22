package hexlet.code.game;

import java.util.Random;

abstract class AbstractGame implements Game {
    protected static final int CORRECT_ANSWERS_THRESHOLD = 3;
    protected final String title;
    protected final Random rand;
    private String userName;

    AbstractGame(String title) {
        this.title = title;
        rand = new Random();
    }

    protected final String getUserName() {
        return userName;
    }

    protected final void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String getDescription() {
        return title;
    }

    protected final void endGameFlow(int trueAnswerCount, String answer, String correctAnswer) {
        if (trueAnswerCount == Calculator.CORRECT_ANSWERS_THRESHOLD) {
            System.out.println("Congratulations, " + userName + "!");
        } else {
            var info = "'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer
                + "'\nLet's try again, " + userName + "!";
            System.out.println(info);
        }
    }
}
