package lab4.main;


import lab4.dao.PyramidDao;
import lab4.model.Pyramid;

import java.util.List;

public class Runner {

    public static void main(String [] args){
        String filePath = "pyramids.csv";
        PyramidDao pyramidDao = new PyramidDao();
        List<Pyramid> pyramids = pyramidDao.loadObjectsFromCSV(filePath, true);
        double base1Average = getBase1Average(pyramids);
        System.out.println("Base 1 Average = " + base1Average);
    }

    public static double getBase1Average(List<Pyramid> pyramids){
        if(pyramids == null || pyramids.size() == 0)
            return 0;

        double sum = pyramids
                .stream()
                .mapToDouble(Pyramid::getBase1)
                .sum();
        return sum / pyramids.size();
    }


}
