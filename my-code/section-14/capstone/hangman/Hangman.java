import java.util.Scanner;

public class Hangman {

    private static Scanner scanner = new Scanner(System.in);

    public static String[] words = { "ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
            "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
            "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
            "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
            "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon",
            "python", "rabbit", "ram", "rat", "raven", "rhino", "salmon", "seal",
            "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
            "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
            "wombat", "zebra" };

    public static String[] gallows = { "+---+\n" +
            "|   |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "=========\n",

            "+---+\n" +
                    "|   |\n" +
                    "O   |\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "=========\n",

            "+---+\n" +
                    "|   |\n" +
                    "O   |\n" +
                    "|   |\n" +
                    "    |\n" +
                    "    |\n" +
                    "=========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|   |\n" +
                    "     |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" + // if you were wondering, the only way to print '\' is with a trailing escape
                                  // character, which also happens to be '\'
                    "     |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" +
                    "/    |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" +
                    "/ \\  |\n" +
                    "     |\n" +
                    " =========\n" };

    public static void main(String[] args) {
        final int MAX_GUESSES = 6;
        int missedGuesses = 0;
        int correctGuesses = 0;
        char misssedLetters[] = new char[MAX_GUESSES];

        // Choose a random word
        String word = randomWord();
        System.out.println(word);
        char correctLetters[] = new char[word.length()];

        while (true) {
            // Print the gallows
            printGallow(missedGuesses);

            // Print the word
            System.out.print("Word: \t");
            printWord(word, correctLetters);

            // Print the missed letters
            System.out.println();
            System.out.print("Misses: ");
            printMissedLetters(misssedLetters);

            // Ask the user for a letter
            System.out.println();
            System.out.print("Guess: \t");
            char guess = scanner.next().charAt(0);

            // Check if the letter is in the word
            if (word.indexOf(guess) == -1) {
                misssedLetters[missedGuesses] = guess;
                missedGuesses++;
            } else {
                correctLetters[correctGuesses] = guess;
                correctGuesses++;
            }

            // Check if the user has won
            if (correctGuesses == word.length()) {
                printGallow(missedGuesses);
                System.out.println("You win! The word was: " + word);
                break;
            }

            // Check if the user has lost
            if (missedGuesses == MAX_GUESSES) {
                printGallow(missedGuesses);
                System.out.println("You lose! The word was: " + word);
                break;
            }
        }
    }

    /**
     * Prints the missed letters from the Hangman game.
     * Each missed letter is printed as a character followed by a space.
     *
     * @param missedLetters an array of integers representing the missed letters,
     *                      where each integer is the ASCII value of the missed
     *                      letter.
     *                      A value of 0 indicates no missed letter at that
     *                      position.
     */
    private static void printMissedLetters(char[] missedLetters) {
        for (int i = 0; i < missedLetters.length; i++) {
            System.out.print(missedLetters[i] + " ");
        }
    }

    /**
     * Prints the gallow at the specified index.
     *
     * @param index the index of the gallow to print
     */
    private static void printGallow(int index) {
        System.out.println(gallows[index]);
    }

    /**
     * Selects a random word from the array of words.
     *
     * @return A randomly selected word from the words array.
     */
    private static String randomWord() {
        int random = (int) (Math.random() * words.length);
        return words[random];
    }

    /**
     * Prints the word with guessed letters revealed and unguessed letters as
     * underscores.
     *
     * @param word    The word to be guessed.
     * @param guesses An array of characters representing the letters that have been
     *                guessed so far.
     */
    private static void printWord(String word, char[] guesses) {
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (contains(guesses, letter)) {
                System.out.print(letter + " ");
            } else {
                System.out.print("_ ");
            }
        }
    }

    /**
     * Checks if the specified letter is present in the array of guessed letters.
     *
     * @param guesses an array of characters representing the guessed letters
     * @param letter  the character to check for in the guesses array
     * @return true if the letter is found in the guesses array, false otherwise
     */
    private static boolean contains(char[] guesses, char letter) {
        for (int i = 0; i < guesses.length; i++) {
            if (guesses[i] == letter) {
                return true;
            }
        }
        return false;
    }
}
