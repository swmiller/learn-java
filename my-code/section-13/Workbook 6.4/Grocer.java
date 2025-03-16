import java.util.Scanner;

public class Grocer {
    public static void main(String[] args) {

        // Instructions for this workbook are on Learn the Part (Workbook 6.3).
        String groceries[] = { "apples", "bananas", "candy", "chocolate", "coffee", "tea" };

        Scanner input = new Scanner(System.in);
        System.out.println("What can I help you find?");
        String item = input.nextLine();

        for (int i = 0; i < groceries.length; i++) {
            if (groceries[i].equals(item)) {
                System.out.println("\nYes, we have that in aisle: " + i);
                break;
            }
        }
    }
}
