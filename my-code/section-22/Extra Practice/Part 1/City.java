public class City {
    private String name;
    private String country;
    private long population;

    // Field constructor
    public City(String name, String country, long population) {
        this.setName(name);
        this.setCountry(country);
        this.setPopulation(population);
    }

    // Copy constructor
    public City(City source) {
        this.setName(source.getName());
        this.setCountry(source.getCountry());
        this.setPopulation(source.getPopulation());
    }

    // Getter and setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }

        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        if (country == null || country.isBlank()) {
            throw new IllegalArgumentException("Country cannot be null or blank");
        }

        this.country = country;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        if (population < 0) {
            throw new IllegalArgumentException("Population cannot be negative");
        }

        this.population = population;
    }
}
