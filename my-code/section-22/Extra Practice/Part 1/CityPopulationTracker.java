import java.util.HashMap;

public class CityPopulationTracker {
    private HashMap<String, City> cityPopulations;

    public CityPopulationTracker() {
        cityPopulations = new HashMap<>();
    }

    public City getCity(String cityName) {
        City originalCity = cityPopulations.get(cityName);
        if (originalCity == null) {
            return null;
        }
        return new City(originalCity.getName(), originalCity.getCountry(), originalCity.getPopulation());
    }

    public void addCity(City city) {
        if (city != null) {
            cityPopulations.put(city.getName(), new City(city.getName(), city.getCountry(), city.getPopulation()));
        }
    }
}
