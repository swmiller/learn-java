package model;

import java.util.ArrayList;
import java.util.List;

public class MovieStore {
    private List<Movie> movies;

    public MovieStore() {
        this.movies = new ArrayList<>();
    }

    public void addMovie(Movie movie) {
        if (movie == null) {
            throw new IllegalArgumentException("Movie cannot be null");
        }
        movies.add(new Movie(movie));
    }

    public List<Movie> filterByGenre(String genre) {
        if (genre == null || genre.isEmpty()) {
            throw new IllegalArgumentException("Genre cannot be null or empty");
        }

        return movies.stream()
                .filter(movie -> movie.getGenre().equalsIgnoreCase(genre))
                .toList();
    }

    public List<Movie> sortByReleaseYear() {
        return movies.stream()
                .sorted((m1, m2) -> Integer.compare(m1.getYear(), m2.getYear()))
                .toList();
    }

    public List<Movie> getTopRatedMovies(int n) {
        return movies.stream()
                .sorted((m1, m2) -> Double.compare(m2.getRating(), m1.getRating()))
                .limit(n)
                .toList();
    }
}
