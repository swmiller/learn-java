public class Receipt {
    public static void main(String[] args) {
        System.out.println("Here's your receipt:\n");

        String[] items = { "Gala", "Granny Smith", "Macintosh" };
        Double[] prices = { 1.99, 1.49, 1.29 };

        for (int i = 0; i < items.length; i++) {
            System.out.println("\t" + items[i] + ": $" + prices[i]);
        }
    }
}
