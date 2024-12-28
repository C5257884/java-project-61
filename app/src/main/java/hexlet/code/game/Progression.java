package hexlet.code.game;

import java.util.Random;
/**
 * Game Scenario.
 * <p>
 * Welcome to the Brain Games!
 * May I have your name? Sam
 * Hello, Sam!
 * What number is missing in the progression?
 * Question: 5 7 9 11 13 .. 17 19 21 23
 * Your answer: 15
 * Correct!
 * Question: 2 5 8 .. 14 17 20 23 26 29
 * Your answer: 11
 * Correct!
 * Question: 14 19 24 29 34 39 44 49 54 ..
 * Your answer: 59
 * Correct!
 * Congratulations, Sam!
 */
public final class Progression extends AbstractGame {
    private static final int LENGTH_OF_PROGRESSION = 10;
    private int indexOfMissMember;
    private StringBuilder progressionStr;
    private ArithmeticProgression arithmeticProgression;

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

    /**
     * CONSTRUCTOR.
     */
    public Progression() {
        super("Progression");
        gameMainQuestion = "What number is missing in the progression?";
    }

    /**
     * Устанавливает случаным образом число для игры.
     * Данное число либо четное, либо - нет, пользователю нужно это определить
     * и дать правильный ответ
     */
    @Override
    protected void generateGameParams() {

        indexOfMissMember = getRand().nextInt(LENGTH_OF_PROGRESSION) + 1;

        // При каждом вопросе - нужен новый экземпляр
        arithmeticProgression = new ArithmeticProgression();

        progressionStr = new StringBuilder();
        String delemiterStr = "";

        for (int i = 1; i <= LENGTH_OF_PROGRESSION; i++) {
            progressionStr.append(delemiterStr)
                .append((i == indexOfMissMember) ? ".." : arithmeticProgression.getMember(i));
            delemiterStr = " ";
        }
    }

    /**
     * Запрос ответа пользователя на вопрос, четное или нет число.
     * @return Введенный пользователем ответ "yes/no"
     */
    @Override
    protected String inputActualAnswer() {

        System.out.println("Question: " + progressionStr);
        System.out.print("Your answer: ");
        return input.nextLine();
    }

    /**
     * Определение пропущенного члена арифметической прогрессии по порядковому номеру ее члена.
     * Возвращенный ответ будет сравниваться с ответом введенным пользователем
     * @return Пропущенный член арифметической прогрессии
     */
    @Override
    protected String getCorrectAnswer() {

        return "" + arithmeticProgression.getMember(indexOfMissMember);
    }
}
