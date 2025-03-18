import java.util.Scanner;

public class Javapedia {
    public static void main(String[] args) {
        System.out.println("Welcome to Javapedia!");

        Scanner scanner = new Scanner(System.in);

        System.out.print("How many historical figures will you register? ");
        int numberOfHistoricalFigures = scanner.nextInt();
        scanner.nextLine();

        String[][] historicalFigures = new String[numberOfHistoricalFigures][3];

        for (int i = 0; i < numberOfHistoricalFigures; i++) {
            System.out.println("\n\tFigure " + (i + 1));
            for (int j = 0; j < historicalFigures[i].length; j++) {
                switch (j) {
                    case 0:
                        System.out.print("Name         : ");
                        break;
                    case 1:
                        System.out.print("Date of birth: ");
                        break;
                    case 2:
                        System.out.print("Occupation   : ");
                        break;
                    default:
                        System.out.println("Undefined field number.");
                        System.exit(1);
                        break;
                }

                historicalFigures[i][j] = scanner.nextLine();
            }
        }

        System.out.println("\nThese are the historical figures you stored:");
        print2DArray(historicalFigures);

        System.out.print("\nWhich figure do you want to see the details of? ");
        String searchName = scanner.nextLine();

        for (int i = 0; i < historicalFigures.length; i++) {
            if (historicalFigures[i][0].equals(searchName)) {
                printEntryDetail(historicalFigures[i]);
                break;
            }
        }
    }

    private static void print2DArray(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void printEntryDetail(String[] entry) {
        System.out.println();
        for (int i = 0; i < entry.length; i++) {
            switch (i) {
                case 0:
                    System.out.print("\tName         : ");
                    break;
                case 1:
                    System.out.print("\tDate of birth: ");
                    break;
                case 2:
                    System.out.print("\tOccupation   : ");
                    break;
                default:
                    System.out.println("Undefined field number.");
                    System.exit(1);
                    break;
            }

            System.out.println(entry[i]);

        }
    }
}
