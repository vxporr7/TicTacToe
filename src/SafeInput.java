import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SafeInput {
    public static String getNonZeroLenString(Scanner sc, String prompt) {
        System.out.print(prompt);
        String data = sc.nextLine();

        if (data.isEmpty()) {
            return getNonZeroLenString(sc, prompt);
        }
        return data;
    }

    public static int getInt(Scanner sc, String prompt) {
        int data;
        System.out.print(prompt);
        String input_data = sc.nextLine();

        try {
            data = Integer.parseInt(input_data);
        } catch (Exception e) {
            return getInt(sc, prompt);
        }

        return data;
    }

    public static double getDouble(Scanner sc, String prompt) {
        double data;
        System.out.print(prompt);
        String input_data = sc.nextLine();

        try {
            data = Double.parseDouble(input_data);
        } catch (Exception e) {
            return getDouble(sc, prompt);
        }

        return data;
    }

    public static int getRangedInt(Scanner sc, String prompt, int low, int high) {
        int data;
        System.out.print(prompt);
        String input_data = sc.nextLine();

        try {
            data = Integer.parseInt(input_data);
        } catch (Exception e) {
            return getRangedInt(sc, prompt, low, high);
        }

        if (data < low || data > high) {
            return getRangedInt(sc, prompt, low, high);
        }

        return data;
    }

    public static double getRangedDouble(Scanner sc, String prompt, double low, double high) {
        double data;
        System.out.print(prompt);
        String input_data = sc.nextLine();

        try {
            data = Double.parseDouble(input_data);
        } catch (Exception e) {
            return getRangedDouble(sc, prompt, low, high);
        }

        if (data < low || data > high) {
            return getRangedDouble(sc, prompt, low, high);
        }

        return data;
    }

    public static boolean getYNConfirm(Scanner sc, String prompt) {
        System.out.print(prompt);
        String input_data = sc.nextLine().toLowerCase();

        return switch (input_data) {
            case "y" -> true;
            case "n" -> false;
            default -> getYNConfirm(sc, prompt);
        };
    }

    public static String getRegExString(Scanner sc, String prompt, String regEx) {
        System.out.print(prompt);
        String input_data = sc.nextLine();

        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(input_data);

        if (!matcher.find()) {
            return getRegExString(sc, prompt, regEx);
        }

        return input_data;
    }
}
