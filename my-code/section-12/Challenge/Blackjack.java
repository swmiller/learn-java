import java.util.Scanner;

public class Blackjack {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nWelcome to Java Casino!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see..");
        System.out.println("..Ready? Press anything to begin!");
        scan.nextLine();

        int playerCard1 = drawRandomCard();
        int playerCard2 = drawRandomCard();
        System.out.println("You get a \n" + cardString(playerCard1) + "\n and a \n" + cardString(playerCard2));

        int playerTotalScore = sumScore(playerCard1, playerCard2);
        System.out.println("Your total is: " + playerTotalScore);

        int dealerCard1 = drawRandomCard();
        int dealerCard2 = drawRandomCard();
        int dealerTotalScore = sumScore(dealerCard1, dealerCard2);
        System.out.println(
                "The dealer shows \n" + cardString(dealerCard1) + "\nand has a card facing down \n" + faceDown());
        System.out.println("The dealer's total is hidden.");

        // Player's turn
        while (true) {
            String playerChoice = hitOrStay();
            if (playerChoice.equals("stay")) {
                break;
            }

            // Player hits
            int newCard = drawRandomCard();
            playerTotalScore += sumScore(0, newCard);
            System.out.println("You get a \n" + cardString(newCard));
            System.out.println("Your new total is: " + playerTotalScore);

            if (playerTotalScore > 21) {
                System.out.println("You busted! Your total is over 21.");
                System.out.println("The dealer wins!");
                System.out.println("Game over!");
                scan.close();
                System.exit(0);
            }
        }

        // Dealer's turn
        System.out.println("Dealer's turn");
        System.out.println(
                "The dealer shows \n" + cardString(dealerCard1) + "\nand a\n"
                        + cardString(dealerCard2));
        System.out.println("The dealer's total is: " + dealerTotalScore);

        while (dealerTotalScore < 17) {
            // Dealer hits
            int newDealerCard = drawRandomCard();
            dealerTotalScore += sumScore(0, newDealerCard);
            System.out.println("The dealer gets a \n" + cardString(newDealerCard));
            System.out.println("The dealer's new total is: " + dealerTotalScore);

            if (dealerTotalScore > 21) {
                System.out.println("The dealer busted! Their total is over 21.");
                System.out.println("You win!");
                System.out.println("Game over!");
                scan.close();
                System.exit(0);
            }
        }
    }

    /**
     * Function name – sumScore
     * 
     * @param card1 (int)
     * @param card2 (int)
     * @return (int)
     *
     *         Inside the function:
     *         1. Returns the sum of the two cards.
     *         2. Any card that is greater than 10 (e.g., 11, 12, 13) is counted as
     *         10 for points value.
     */
    private static int sumScore(int card1, int card2) {
        // Any card that is greater than 10 (e.g., 11, 12, 13) is counted as 10 for
        // points value.
        return Math.min(card1, 10) + Math.min(card2, 10);
    }

    /**
     * Function name – drawRandomCard
     * 
     * @return (int)
     *
     *         Inside the function:
     *         1. Gets a random number between 1 and 13.
     *         2. Returns a card.
     */
    private static int drawRandomCard() {
        return (int) (Math.random() * 13) + 1;
    }

    /**
     * Function name – cardString
     * 
     * @param cardNumber (int)
     * @return (String)
     *
     *         Inside the function:
     *         1. Returns a String drawing of the card.
     */
    private static String cardString(int cardNumber) {
        String cardImage = "";

        switch (cardNumber) {
            case 1:
                cardImage = "   _____\n" +
                        "  |A _  |\n" +
                        "  | ( ) |\n" +
                        "  |(_'_)|\n" +
                        "  |  |  |\n" +
                        "  |____V|\n";
                break;
            case 2:
                cardImage = "   _____\n" +
                        "  |2    |\n" +
                        "  |  o  |\n" +
                        "  |     |\n" +
                        "  |  o  |\n" +
                        "  |____Z|\n";
                break;
            case 3:
                cardImage = "   _____\n" +
                        "  |3    |\n" +
                        "  | o o |\n" +
                        "  |     |\n" +
                        "  |  o  |\n" +
                        "  |____E|\n";
                break;
            case 4:
                cardImage = "   _____\n" +
                        "  |4    |\n" +
                        "  | o o |\n" +
                        "  |     |\n" +
                        "  | o o |\n" +
                        "  |____h|\n";
                break;
            case 5:
                cardImage = "   _____ \n" +
                        "  |5    |\n" +
                        "  | o o |\n" +
                        "  |  o  |\n" +
                        "  | o o |\n" +
                        "  |____S|\n";
                break;
            case 6:
                cardImage = "   _____ \n" +
                        "  |6    |\n" +
                        "  | o o |\n" +
                        "  | o o |\n" +
                        "  | o o |\n" +
                        "  |____6|\n";
                break;
            case 7:
                cardImage = "   _____ \n" +
                        "  |7    |\n" +
                        "  | o o |\n" +
                        "  |o o o|\n" +
                        "  | o o |\n" +
                        "  |____7|\n";
                break;
            case 8:
                cardImage = "   _____ \n" +
                        "  |8    |\n" +
                        "  |o o o|\n" +
                        "  | o o |\n" +
                        "  |o o o|\n" +
                        "  |____8|\n";
                break;
            case 9:
                cardImage = "   _____ \n" +
                        "  |9    |\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |____9|\n";
                break;
            case 10:
                cardImage = "   _____ \n" +
                        "  |10  o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |___10|\n";
                break;
            case 11:
                cardImage = "   _____\n" +
                        "  |J  ww|\n" +
                        "  | o {)|\n" +
                        "  |o o% |\n" +
                        "  | | % |\n" +
                        "  |__%%[|\n";
                break;
            case 12:
                cardImage = "   _____\n" +
                        "  |Q  ww|\n" +
                        "  | o {(|\n" +
                        "  |o o%%|\n" +
                        "  | |%%%|\n" +
                        "  |_%%%O|\n";
                break;
            case 13:
                cardImage = "   _____\n" +
                        "  |K  WW|\n" +
                        "  | o {)|\n" +
                        "  |o o%%|\n" +
                        "  | |%%%|\n" +
                        "  |_%%%>|\n";
                break;
            default:
                cardImage = "Invalid card number";
        }

        return cardImage;
    }

    public static String faceDown() {
        return "   _____\n" +
                "  |     |\n" +
                "  |  J  |\n" +
                "  | JJJ |\n" +
                "  |  J  |\n" +
                "  |_____|\n";
    }

    /**
     * Function name – hitOrStay
     * 
     * @return (String)
     *
     *         Inside the function:
     *         1. Asks the user to hit or stay.
     *         2. If the user doesn't enter "hit" or "stay", keep asking them to try
     *         again by printing:
     *         Please write 'hit' or 'stay'
     *         3. Returns the user's option
     */
    private static String hitOrStay() {
        String playerChoice = "";
        while (!playerChoice.equals("hit") && !playerChoice.equals("stay")) {
            System.out.println("Do you want to 'hit' or 'stay' (press ENETER to 'hit')");
            playerChoice = scan.nextLine();

            if (playerChoice.isEmpty()) {
                playerChoice = "hit";
            }
        }

        return playerChoice;
    }
}
