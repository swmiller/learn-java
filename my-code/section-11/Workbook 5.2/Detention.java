import java.util.Scanner;

public class Detention {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Hi Bart. I can write lines for you.\nWhat do you want me to write?");
        // See Learn the Part for the instructions.
        String bartsInput = input.nextLine();

        System.out.println("\nHere you go ...");
        for (int i = 0; i < 99; i++) {
            System.out.println(bartsInput);
        }

        input.close();
    }
}
