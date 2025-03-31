package model;

public class Movie {

    private String title;
    private String director;
    private String genre;
    private int year;
    private double rating;

    public Movie(String title, String director, String genre, int year, double rating) {
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
    }

    public Movie(Movie source) {
        if (source == null) {
            throw new IllegalArgumentException("Source movie cannot be null");
        }

        this.title = source.title;
        this.director = source.director;
        this.genre = source.genre;
        this.year = source.year;
        this.rating = source.rating;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return title + "\t" + director + "\t" + genre + "\t" + year + "\t" + rating;
    }
}
