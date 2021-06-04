package dao;

import model.Country;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountriesDAO implements ObjectDAO{

    @Override
    public List<Country> readCSVFile(String path, boolean hasHeader) {
        List<Country> countries = new ArrayList<>();
        File file = new File(path);
        Scanner scanner = null;
        try{
            scanner = new Scanner(file);
            scanner.nextLine();
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String [] features = line.split(",");
                Country country = new Country(features[0], Integer.parseInt(features[1]), features[2]);
                countries.add(country);
            }
        }catch (FileNotFoundException fileNotFoundException){
            System.out.println(path + " File Not Found!!!.");
        }finally {
            if(scanner != null)
                scanner.close();
        }
        return countries;
    }
}
