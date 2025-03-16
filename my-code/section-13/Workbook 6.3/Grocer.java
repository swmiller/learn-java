public class Grocer {
    public static void main(String[] args) {

        // Instructions for this workbook are on Learn the Part (Workbook 6.3).
        String groceries[] = { "apples", "bananas", "candy", "chocolate", "coffee", "tea" };

        System.out.println("\nDo you sell coffee?");
        for (int i = 0; i < groceries.length; i++) {
            if (groceries[i].equals("coffee")) {
                System.out.println("\nYes, we have that in aisle: " + i);
            }
        }
    }
}
