package hexlet.code.game;

/**
 * Game Scenario.
 * <p>
 * Welcome to the Brain Games!<br/>
 * May I have your name? Sam<br/>
 * Hello, Sam!<br/>
 * What is the result of the expression?<br/>
 * Question: 12 * 9<br/>
 * Your answer: 108<br/>
 * Correct!<br/>
 * Question: 17 + 10<br/>
 * Your answer: 27<br/>
 * Correct!<br/>
 * Question: 9 - 11<br/>
 * Your answer: -2<br/>
 * Correct!<br/>
 * Congratulations, Sam!<br/>
 */
public final class Calculator extends AbstractGame {
//    private static final int MAX_VALUE = 100;
    private static final int NUMBER_OF_OPERATION = 3;
    private int operand1;
    private int operand2;
    private String operation;
    private String loopQuestion;

    public Calculator() {
        super("Calc");
        setGameMainQuestion("What is the result of the expression?");
    }

    /**
     * Генерирует с помощью генератора случайных чисел<br/>
     * 2 случаных числа и операцию, одну из 3-х(+,-,*), которая<br/>
     * должна быть произведена пользователем над этими числами.
     * Также устанавливается текст вопроса, который будет задан пользователю
     */
    @Override
    protected void generateGameParams() {
        operand1 = getRand().nextInt(MAX_VALUE) + 1;
        operand2 = getRand().nextInt(MAX_VALUE) + 1;
        operation = getOperation(getRand().nextInt(NUMBER_OF_OPERATION));
        loopQuestion = "Question: " + operand1 + " " + operation + " " + operand2;
    }

    /**
     * Запрос ответа пользователя на вопрос, четное или нет число.
     * @return Введенный пользователем ответ "yes/no"
     */
    @Override
    protected String inputActualAnswer() {

        System.out.println(loopQuestion);
        System.out.print("Your answer: ");
        return input.nextLine();
    }

    /**
     * Определение результата операции, которую предложено вычислить ползователю.
     * Возвращаемый ответ будет сравниваться с ответом введенным пользователем
     * @return Результат операции [operand1 operation operand2]
     */
    @Override
    protected String getCorrectAnswer() {
        return eval(operand1, operand2, operation);
    }

    private String eval(int inOperand1, int inOperand2, String inOperation) {

        return switch (inOperation) {
            case "+" -> "" + (inOperand1 + inOperand2);
            case "-" -> "" + (inOperand1 - inOperand2);
            case "*" -> "" + (inOperand1 * inOperand2);
            default -> throw new IllegalStateException("Unexpected value: " + inOperation);
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
