package model;

public class Country {
    private String name;
    private int id;
    private String continent;

    public Country(String name, int id, String continent) {
        this.name = name;
        this.id = id;
        this.continent = continent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }
}
