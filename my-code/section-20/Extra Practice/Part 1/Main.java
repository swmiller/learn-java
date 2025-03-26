import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String title = promptForTitle(scanner);
        String publisher = promptForPublisher(scanner);
        int issueNumber = promptForIssueNumber(scanner);
        int publicationYear = promptForPublicationYear(scanner);

        Magazine newMagazine = new Magazine(title, publisher, issueNumber, publicationYear);

        MagazineLibrary library = new MagazineLibrary();
        library.addMagazine(newMagazine);

        System.out.println("Magazine added to the library: " + newMagazine.getTitle());
    }

    public static boolean isNullOrBlank(String input) {
        return input == null || input.trim().isEmpty();
    }

    public static boolean incorrectIssueNumber(int issueNumber) {
        return issueNumber <= 0;
    }

    public static String promptForTitle(Scanner input) {
        String title;
        do {
            System.out.print("Enter the magazine title: ");
            title = input.nextLine();
            if (isNullOrBlank(title)) {
                System.out.println("Title cannot be null or blank. Please try again.");
            }
        } while (isNullOrBlank(title));
        return title;
    }

    public static String promptForPublisher(Scanner input) {
        String publisher;
        do {
            System.out.print("Enter the magazine publisher: ");
            publisher = input.nextLine();
            if (isNullOrBlank(publisher)) {
                System.out.println("Publisher cannot be null or blank. Please try again.");
            }
        } while (isNullOrBlank(publisher));
        return publisher;
    }

    public static int promptForIssueNumber(Scanner input) {
        int issueNumber;
        do {
            System.out.print("Enter the magazine issue number: ");
            while (!input.hasNextInt()) {
                System.out.println("Invalid input. Please enter a positive integer.");
                input.next(); // Clear invalid input
            }
            issueNumber = input.nextInt();
            input.nextLine(); // Consume the newline character
            if (incorrectIssueNumber(issueNumber)) {
                System.out.println("Issue number must be greater than 0. Please try again.");
            }
        } while (incorrectIssueNumber(issueNumber));
        return issueNumber;
    }

    public static int promptForPublicationYear(Scanner input) {
        int publicationYear;
        do {
            System.out.print("Enter the magazine publication year: ");
            while (!input.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid year.");
                input.next(); // Clear invalid input
            }
            publicationYear = input.nextInt();
            input.nextLine(); // Consume the newline character
            if (publicationYear <= 0) {
                System.out.println("Publication year must be a positive number. Please try again.");
            }
        } while (publicationYear <= 0);
        return publicationYear;
    }
}