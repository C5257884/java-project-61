package hexlet.code.game;

import java.util.Random;

abstract class AbstractGame implements Game {
    protected static final int CORRECT_ANSWERS_THRESHOLD = 3;
    private final Random rand;
    private final String title;
    private String userName;

    AbstractGame(String gameTitle) {
        title = gameTitle;
        rand = new Random();
    }

    protected final String getUserName() {
        return userName;
    }

    protected final void setUserName(String newUserName) {
        userName = newUserName;
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

    protected Random getRand() {
        return rand;
    }
}
