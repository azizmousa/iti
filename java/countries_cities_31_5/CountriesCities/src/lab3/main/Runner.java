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

        System.out.println("Max Population City In each Country:");
        for(City c : getMaxPopulationCities(country_city_map))
            System.out.println(c);



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

}