import java.util.Scanner;

public class SafeInput {

    // Get an integer within a range
    public static int getRangedInt(Scanner console, String prompt, int low, int high) {
        int input;
        do {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");
            while (!console.hasNextInt()) {
                console.next(); // discard invalid input
                System.out.print("Invalid input. " + prompt + " [" + low + " - " + high + "]: ");
            }
            input = console.nextInt();
        } while (input < low || input > high);
        console.nextLine(); // clear buffer
        return input;
    }

    // Get a non-empty string
    public static String getNonZeroLenString(Scanner console, String prompt) {
        String input;
        do {
            System.out.print(prompt + ": ");
            input = console.nextLine().trim();
        } while (input.length() == 0);
        return input;
    }

    // Yes/No confirmation
    public static boolean getYNConfirm(Scanner console, String prompt) {
        String input;
        do {
            System.out.print(prompt + " [Y/N]: ");
            input = console.nextLine().trim().toUpperCase();
        } while (!input.equals("Y") && !input.equals("N"));
        return input.equals("Y");
    }
}
