import java.util.Scanner;

public class CountingTool {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // See Learn the Part for the instructions.
        System.out.print("Hi, Timmy. Choose a number to count to: ");
        int num = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < num + 1; i++) {
            System.out.print(i + " ");
        }

        scan.close();
    }
}
