public class Store {
    private Movie[] movies;

    public Store() {
        this.movies = new Movie[10];
    }

    public Movie getMovie(int index) {
        return new Movie(movies[index]);
    }

    public void setMovie(Movie movie, int index) {
        this.movies[index] = new Movie(movie);
    }

    public void printStore() {
        System.out.println("\n********************************MOVIE STORE*******************************");
        for (int i = 0; i < movies.length; i++) {
            if (movies[i] != null)
                System.out.println(movies[i]);
        }
    }
}
