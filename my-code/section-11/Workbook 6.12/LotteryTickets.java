import java.lang.reflect.Array;
import java.util.Arrays;

public class LotteryTickets {
    public static void main(String[] args) {

        // Instructions for this workbook are on Learn the Part (workbook 6.12)
        int[] ticket = { 34, 43, 45, 65, 21, 54 };
        int[] ticket2 = Arrays.copyOf(ticket, ticket.length);

        System.out.print("Ticket 1 numbers: ");
        // Task 3 - Call printTicketNumbers for int[] ticket.
        printArray(ticket);

        System.out.print("\n\nTicket 2 numbers: ");
        // Task 3 - Call printTicketNumbers for int[] ticket2.
        printArray(ticket2);
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
