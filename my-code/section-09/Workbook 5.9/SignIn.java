import java.util.Scanner;

public class SignIn {
    public static void main(String[] args) {
        String username = "Samantha";
        String password = "Java <3";

        /*
         * Task 1
         * 1. Pick up a username and password from the user.
         */
        Scanner scan = new Scanner(System.in);
        System.out.println("\nWelcome to Javagram! Sign in below\n");
        System.out.print("- Username: ");
        // pick up username
        String loginUsername = scan.nextLine();

        System.out.print("- Password: ");
        // pick up password
        String loginPassword = scan.nextLine();

        // see Learn the Part for the remaining instructions.
        while (!loginUsername.equals(username) || !loginPassword.equals(password)) {
            System.out.println("\nIncorrect, please try again!\n");

            System.out.print("- Username: ");
            loginUsername = scan.nextLine();

            System.out.print("- Password: ");
            loginPassword = scan.nextLine();
        }
        /*
         * will be useful for task 2
         * 
         * System.out.println("\nIncorrect, please try again!\n");
         * System.out.print("- Username: ");
         * usernameEntry = scan.nextLine();
         * System.out.print("- Password: ");
         * passwordEntry = scan.nextLine();
         * 
         * 
         */

        System.out.println("\nSign in successful. Welcome, " + username + "!");

        scan.close();

    }
}
