package hexlet.code.game;

import java.util.Random;

abstract class AbstractGame implements Game {
    protected static final int CORRECT_ANSWERS_THRESHOLD = 3;
    protected final int gameHotPoint;
    protected String title;
    protected String userName;
    protected Random rand;

    AbstractGame(int gameHotPoint, String title) {
        this.gameHotPoint = gameHotPoint;
        this.title = title;
        rand = new Random();
    }

    @Override
    public void outDescription() {
        System.out.println(gameHotPoint + " - " + title);
    }

    @Override
    public void play() {
        System.out.println("My index: " + gameHotPoint + " my title: " + title); // ##TODO debug mode
    }

    @Override
    public int getHotPoint() {
        return gameHotPoint;
    }

    protected void endGameFlow(int trueAnswerCount, String answer, String correctAnswer) {
        if (trueAnswerCount == CalculatorGame.CORRECT_ANSWERS_THRESHOLD) {
            System.out.println("Congratulations, " + userName + "!");
        } else {
            var info = "'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer
                + "'\nLet's try again, " + userName + "!";
            System.out.println(info);
        }
    }
}
