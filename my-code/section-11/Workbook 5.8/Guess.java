import java.util.Scanner;

public class Guess {
    public static void main(String[] args) {

        int computerNumber = (int) (Math.random() * 5) + 1;

        System.out.print("I chose a number between 1 and 5. Try to guess it: ");

        Scanner scan = new Scanner(System.in);

        // See Learn the Part for detailed instructions.
        while (true) {
            int guess = scan.nextInt();
            scan.nextLine();

            if (guess == computerNumber) {
                System.out.println("You guessed it!");
                break;
            } else {
                System.out.print("Try again: ");
            }
        }

        scan.close();
    }

}
