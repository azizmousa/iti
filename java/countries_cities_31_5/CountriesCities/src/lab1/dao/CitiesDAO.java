package lab1.dao;

import lab1.model.City;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CitiesDAO implements ObjectDAO{

    @Override
    public List<City> readCSVFile(String path, boolean hasHeader) {
        List<City> cities = new ArrayList<>();
        File file = new File(path);
        Scanner scanner = null;
        try{
            scanner = new Scanner(file);

            if(hasHeader)
                scanner.nextLine();

            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String [] features = line.split(",");
                City city = new City(Integer.parseInt(features[0]), Integer.parseInt(features[1]), features[2],
                        Boolean.parseBoolean(features[3]), Long.parseLong(features[4]));
                cities.add(city);
            }
        }catch (FileNotFoundException fileNotFoundException){
            System.out.println(path + " File Not Found!!!.");
        }finally {
            if(scanner != null)
                scanner.close();
        }
        return cities;
    }
}
