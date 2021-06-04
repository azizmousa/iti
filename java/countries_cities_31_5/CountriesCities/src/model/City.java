package model;

public class City {
    private int country_id;
    private int city_id;
    private String name;
    private boolean capital;
    private long population;

    public City(int country_id, int city_id, String name, boolean capital, long population) {
        this.country_id = country_id;
        this.city_id = city_id;
        this.name = name;
        this.capital = capital;
        this.population = population;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCapital() {
        return capital;
    }

    public void setCapital(boolean capital) {
        this.capital = capital;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }
}
