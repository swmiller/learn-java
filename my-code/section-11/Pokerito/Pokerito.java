import java.util.Scanner;

public class Pokerito {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Let's play Pokerito. Type anything when you're ready.");
        scan.nextLine();

        printRules();
        scan.nextLine();

        String playerCard = randomCard();
        String computerCard = randomCard();

        System.out.println("Here's your card:");
        System.out.println(playerCard);

        System.out.println("\nHere's the computer's card:");
        System.out.println(computerCard);

        int yourMatches = 0;
        int computerMatches = 0;

        System.out.println("\nNow, the dealer will draw five cards. Press enter to continue.");
        scan.nextLine();

        for (int i = 1; i <= 5; i++) {
            System.out.println("Card " + i);
            String riverCard = randomCard();
            System.out.println(riverCard);

            if (isMatch(playerCard, riverCard)) {
                yourMatches++;
            }

            if (isMatch(computerCard, riverCard)) {
                computerMatches++;
            }

            scan.nextLine();
        }

        determineWinner(yourMatches, computerMatches);

        scan.close();
    }

    private static void determineWinner(int yourMatches, int computerMatches) {
        System.out.println("\nYour number of matches: " + yourMatches);
        System.out.println("Computer number of matches: " + computerMatches);

        if (yourMatches > computerMatches) {
            System.out.println("You win!");
        } else if (yourMatches < computerMatches) {
            System.out.println("The computer wins!");
        } else {
            System.out.println("Everyone wins!");
        }
    }

    private static boolean isMatch(String holdCard, String riverCard) {
        return holdCard.equals(riverCard);
    }

    private static void printRules() {

        System.out.println("It's like Poker, but a lot simpler.");
        System.out.println("\n - There are two players, you and the computer.");
        System.out.println(" - The dealer will give each player one card.");
        System.out.println(" - Then, the dealer will draw five cards (the river)");
        System.out.println(" - The player with the most river matches wins!");
        System.out.println(" - If the matches are equal, everyone's a winner!");
        System.out.println("\n - Ready? Type anything if you are.");
    }

    /**
     * Task 1
     * 
     * Function name – randomCard
     * 
     * @return (String)
     * 
     *         Inside the function:
     *         1. Gets a random number between 1 and 13.
     *         2. Returns a card that matches the random number (get the String
     *         values from cards.text).
     */
    private static String randomCard() {
        int randomNum = (int) (Math.random() * 13) + 1;
        String card = "";

        switch (randomNum) {
            case 1:
                card = "   _____\n" +
                        "  |A _  |\n" +
                        "  | ( ) |\n" +
                        "  |(_'_)|\n" +
                        "  |  |  |\n" +
                        "  |____V|\n";
                break;
            case 2:
                card = "   _____\n" +
                        "  |2    |\n" +
                        "  |  o  |\n" +
                        "  |     |\n" +
                        "  |  o  |\n" +
                        "  |____Z|\n";
                break;
            case 3:
                card = "   _____\n" +
                        "  |3    |\n" +
                        "  | o o |\n" +
                        "  |     |\n" +
                        "  |  o  |\n" +
                        "  |____E|\n";
                break;
            case 4:
                card = "   _____\n" +
                        "  |4    |\n" +
                        "  | o o |\n" +
                        "  |     |\n" +
                        "  | o o |\n" +
                        "  |____h|\n";
                break;
            case 5:
                card = "   _____ \n" +
                        "  |5    |\n" +
                        "  | o o |\n" +
                        "  |  o  |\n" +
                        "  | o o |\n" +
                        "  |____S|\n";
                break;
            case 6:
                card = "   _____ \n" +
                        "  |6    |\n" +
                        "  | o o |\n" +
                        "  | o o |\n" +
                        "  | o o |\n" +
                        "  |____6|\n";
                break;
            case 7:
                card = "   _____ \n" +
                        "  |7    |\n" +
                        "  | o o |\n" +
                        "  |o o o|\n" +
                        "  | o o |\n" +
                        "  |____7|\n";
                break;
            case 8:
                card = "   _____ \n" +
                        "  |8    |\n" +
                        "  |o o o|\n" +
                        "  | o o |\n" +
                        "  |o o o|\n" +
                        "  |____8|\n";
                break;
            case 9:
                card = "   _____ \n" +
                        "  |9    |\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |____9|\n";
                break;
            case 10:
                card = "   _____ \n" +
                        "  |10  o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |___10|\n";
                break;
            case 11:
                card = "   _____\n" +
                        "  |J  ww|\n" +
                        "  | o {)|\n" +
                        "  |o o% |\n" +
                        "  | | % |\n" +
                        "  |__%%[|\n";
                break;
            case 12:
                card = "   _____\n" +
                        "  |Q  ww|\n" +
                        "  | o {(|\n" +
                        "  |o o%%|\n" +
                        "  | |%%%|\n" +
                        "  |_%%%O|\n";
                break;
            case 13:
                card = "   _____\n" +
                        "  |K  WW|\n" +
                        "  | o {)|\n" +
                        "  |o o%%|\n" +
                        "  | |%%%|\n" +
                        "  |_%%%>|\n";
                break;
            default:
                card = "No such card";
        }

        return card;
    }

}
