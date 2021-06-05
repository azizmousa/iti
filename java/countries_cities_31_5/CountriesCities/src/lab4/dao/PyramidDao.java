package lab4.dao;

import lab4.main.Parser;
import lab4.model.Pyramid;


import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PyramidDao implements ObjectDao {

    @Override
    public List<Pyramid> loadObjectsFromCSV(String path, boolean hasHeader) {
        File file = new File(path);
        List<Pyramid> pyramids = new ArrayList<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            if (hasHeader)
                if (scanner.hasNextLine()) scanner.nextLine();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if(line.endsWith(","))
                    line += ",";
                String[] features = line.replace(",,", ", ,").split(",");

                if (features.length > 0) {
                    Pyramid pyramid = new Pyramid(features[0], features[1], features[2], features[4], features[12], features[13],
                            features[14], features[15], Parser.parseToInt(features[3]), Parser.parseToDouble(features[5]),
                            Parser.parseToDouble(features[6]), Parser.parseToDouble(features[7]),
                            Parser.parseToDouble(features[8]),
                            Parser.parseToDouble(features[9]),
                            Parser.parseToDouble(features[10]), Parser.parseToDouble(features[11]));

                    pyramids.add(pyramid);
                }
            }
        } catch (FileNotFoundException | ParseException ex) {
            ex.printStackTrace();
        }finally {
            if(scanner != null) scanner.close();
        }
        return pyramids;
    }
}
