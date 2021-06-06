package lab3.main;

import lab1.dao.CitiesDAO;
import lab1.dao.CountriesDAO;
import lab1.model.City;
import lab1.model.Country;

import java.util.*;
import java.util.stream.Collectors;


public class Runner {
    public static void main(String [] args){
        CountriesDAO countriesDAO = new CountriesDAO();
        CitiesDAO citiesDAO = new CitiesDAO();
        List<Country> countries = countriesDAO.readCSVFile("countries.csv", true);
        List<City> cities = citiesDAO.readCSVFile("cities.csv", true);

        Map<Integer, List<City>> country_city_map = new HashMap<>();

        for(City c : cities){
            if(!country_city_map.containsKey(c.getCountry_id()))
                country_city_map.put(c.getCountry_id(), new ArrayList<>());
            country_city_map.get(c.getCountry_id()).add(c);
        }

        try {
            List<City> cs = getMaxPopulationCities(country_city_map);
            System.out.println("Max Population City In each Country:");
            for (City c : cs)
                System.out.println(c);
        }catch (NoSuchElementException e){
            System.err.println("Max Population City In each Country: No Cities Found.!!!");
        }
        String continent = "South America";
        try {
            City city = getMaxPopulationCityByContinent(countries, country_city_map, continent);
            System.out.print("Max Population City In " + continent + ": ");
            System.out.println(city);
        }catch (NoSuchElementException e){
            System.err.println("Max Population City In " + continent + ": No Cities Found.!!!");
        }

        try {
            Map<String, City> maxPerContinent = getMaxPopulationCitiesInContinents(countries, country_city_map);
//            System.out.print("Max Population City In " + continent + ": ");
            maxPerContinent.forEach( (k, v) -> System.out.println("Max Population City in "
                    + k + " Continent is " + v.getName())
            );
//            System.out.println(city);
        }catch (NoSuchElementException e){
            System.err.println("Max Population City In " + continent + ": No Cities Found.!!!");
        }

        try{
            City city = getMaxPopulationCapital(country_city_map);
            System.out.print("Max Population Capital: ");
            System.out.println(city);
        }catch (NoSuchElementException e){
            System.err.println("Max Population Capital: No Cities Found.!!!");
        }
    }

    public static List<City> getMaxPopulationCities(Map<Integer, List<City>> countries_cities_map){
        List<City> maxPopCities = new ArrayList<>();
        countries_cities_map.values()
                .forEach(v -> {
                    City maxCity = v.stream()
                            .max(Comparator.comparing(City::getPopulation))
                            .orElseThrow(NoSuchElementException::new);
                    maxPopCities.add(maxCity);
                });
        return maxPopCities;
    }

    public static City getMaxPopulationCityByContinent(List<Country> countries,
                                                       Map<Integer, List<City>> countries_cities_map, String continent){
        List<Country> continentCountries = countries
                .stream().filter(country1 -> country1.getContinent()
                        .toLowerCase(Locale.ROOT).equals(continent.toLowerCase(Locale.ROOT)))
                .collect(Collectors.toList());

        return countries_cities_map.values()
                .stream()
                .flatMap(List::stream)
                .filter(city ->
                    continentCountries.stream().anyMatch(country -> country.getId() == city.getCountry_id())

                ).max(Comparator.comparing(City::getPopulation)).orElseThrow(NoSuchElementException::new);
    }

    public static Map<String, City> getMaxPopulationCitiesInContinents(List<Country> countries,
                                                       Map<Integer, List<City>> countries_cities_map){
        Map<String, City> maxCityContinent = new HashMap<>();
        Map<String, List<Country>> continents = countries
                .stream()
                .collect(Collectors.groupingBy(Country::getContinent));

        continents.keySet().forEach(continent -> maxCityContinent.put(continent,
                getMaxPopulationCityByContinent(countries, countries_cities_map, continent)));

        return maxCityContinent;
    }

    public static City getMaxPopulationCapital(Map<Integer, List<City>> countries_cities_map){
       return countries_cities_map.values()
               .stream()
               .flatMap(List::stream)
               .filter(City::isCapital)
               .max(Comparator.comparing(City::getPopulation))
               .orElseThrow(NoSuchElementException::new);
    }

}
