public class Doubles {
    public static void main(String[] args) {

        // See Learn the Part for instructions.

        int dice1;
        int dice2;

        dice1 = rollDice();
        dice2 = rollDice();

        printDice(dice1, dice2);

        // Loop till dice1 and dice2 are equal
        while (dice1 != dice2) {
            dice1 = rollDice();
            dice2 = rollDice();
            printDice(dice1, dice2);
        }
    }

    /**
     * Function name: rollDice -- rolls a dice between 1 and 6
     * 
     * @return randomNumber (int)
     *
     */
    private static int rollDice() {
        // Generate a random number between 1 and 6
        int randomNumber = (int) (Math.random() * 6) + 1;
        return randomNumber;
    }

    private static void printDice(int dice1, int dice2) {
        System.out.println("\nDice 1: " + dice1);
        System.out.println("Dice 2: " + dice2);

        if (dice1 == dice2) {
            System.out.println("You rolled Doubles!");
        }
    }
}
