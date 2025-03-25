import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Store store = new Store();

        Movie[] movies = new Movie[] {
                new Movie("The Shawshank Redemption", "BlueRay", 9.2),
                new Movie("The Godfather", "BlueRay", 9.1),
                new Movie("The Godfather: Part II", "DVD", 9.0),
                new Movie("The Dark Knight", "BlueRay", 9.0),
                new Movie("Schindler's List", "DVD", 8.9),
                new Movie("The Lord of the Rings: The Return of the King", "BlueRay", 8.9),
                new Movie("Pulp Fiction", "DVD", 8.8),
                new Movie("The Lord of the Rings: The Fellowship of the Ring", "DVD", 8.8)
        };

        for (int i = 0; i < movies.length; i++) {
            store.setMovie(movies[i], i);
        }

        store.printStore();

        Scanner scanner = new Scanner(System.in);
        String userChoice = "";

        while (!userChoice.equals("stop")) {
            System.out.print("To edit another rating, type: 'continue': ");
            userChoice = scanner.next();

            if (userChoice.equals("stop"))
                break;

            System.out.print("\nPlease choose an integer between 0 - 9: ");
            var movieIndex = scanner.nextInt();
            scanner.nextLine();

            var movie = store.getMovie(movieIndex);
            System.out.print("Set a new rating for " + movie.getName() + ": ");
            var newRating = scanner.nextDouble();
            scanner.nextLine();

            movie.setRating(newRating);
            store.setMovie(movie, movieIndex);

            store.printStore();
        }

        scanner.close();
    }

}
