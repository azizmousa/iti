package main;

import dao.CitiesDAO;
import dao.CountriesDAO;
import model.City;
import model.Country;

import java.util.*;

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

        country_city_map.forEach((k, v) -> {
            for(int i=1; i<v.size();++i){
                int index = i;
                for(int j = i-1; j>=0;--j){
                    if(v.get(index).greaterThan(v.get(j))) {
                        Collections.swap(v, index, j);
                        index--;
                    }
                }
            }
            System.out.println("Key = " + k + " Value = " + v);
        });
    }
}
