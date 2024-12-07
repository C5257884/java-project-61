package hexlet.code;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Cli {
    public static String getUserName(String question) {
        Scanner input = new Scanner(System.in);

        System.out.print(question + " ");

        try {
            return input.nextLine();
        } catch (NoSuchElementException e) {
//            throw new RuntimeException(e);
            return "somthing else";
        }

    }

}
