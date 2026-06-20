import java.util.Scanner;

public class PasswordStrengthChecker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        boolean hasUppercase = false;
        boolean hasNumber = false;
        boolean hasSymbol = false;

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            if (Character.isUpperCase(ch)) {
                hasUppercase = true;
            } else if (Character.isDigit(ch)) {
                hasNumber = true;
            } else if (!Character.isLetterOrDigit(ch)) {
                hasSymbol = true;
            }
        }

        boolean lengthCheck = password.length() >= 8;

        int score = 0;

        if (lengthCheck) score++;
        if (hasUppercase) score++;
        if (hasNumber) score++;
        if (hasSymbol) score++;

        String strength;

        if (score <= 2) {
            strength = "WEAK";
        } else if (score == 3) {
            strength = "MEDIUM";
        } else {
            strength = "STRONG";
        }

        System.out.println("\n----- Password Analysis -----");

        System.out.println("Length Check (8+ chars): " +
                (lengthCheck ? "Passed" : "Failed"));

        System.out.println("Uppercase Letter: " +
                (hasUppercase ? "Found" : "Not Found"));

        System.out.println("Number: " +
                (hasNumber ? "Found" : "Not Found"));

        System.out.println("Symbol: " +
                (hasSymbol ? "Found" : "Not Found"));

        System.out.println("\nPassword Strength: " + strength);

        sc.close();
    }
}