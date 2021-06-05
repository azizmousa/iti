package lab4.main;


import lab4.dao.PyramidDao;
import lab4.model.Pyramid;

import java.util.List;

public class Runner {

    public static void main(String [] args){
        String filePath = "pyramids.csv";
        PyramidDao pyramidDao = new PyramidDao();
        List<Pyramid> pyramids = pyramidDao.loadObjectsFromCSV(filePath, true);
        for(Pyramid p : pyramids){
            System.out.println(p);
        }
        System.out.println("Number of pyramids = " + pyramids.size());
    }



}
