package hexlet.code;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Cli {
    public static String inputString(String question) {
        Scanner input = new Scanner(System.in);

        System.out.print(question + " ");

        try {
            return input.nextLine();
        } catch (NoSuchElementException e) {
//            throw new RuntimeException(e);
            return "somthing else";
        }

    }

    public static int inputIntNumber(String question) {

        Scanner input = new Scanner(System.in);
        System.out.print(question + " ");

        try {
            return input.nextInt();
        } catch (NoSuchElementException e) {
//            throw new RuntimeException(e);
            return 0;
        }
    }
}
