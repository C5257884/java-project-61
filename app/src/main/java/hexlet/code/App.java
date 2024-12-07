package hexlet.code;

public class App {
    public static final String GREET_MSG = "Welcome to the Brain Games!";
    public static void main(String[] args) {
        System.out.println(GREET_MSG);
        var name = Cli.getUserName("May I have your name?");
        System.out.println("Hello, " + name + "!");
    }
}
