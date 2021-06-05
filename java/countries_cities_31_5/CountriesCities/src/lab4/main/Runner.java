package lab4.main;


import lab4.dao.PyramidDao;
import lab4.model.Pyramid;

import java.util.List;
import java.util.stream.Collectors;

public class Runner {

    public static void main(String [] args){
        String filePath = "pyramids.csv";
        PyramidDao pyramidDao = new PyramidDao();
        List<Pyramid> pyramids = pyramidDao.loadObjectsFromCSV(filePath, true);

        double base1Average = getBase1Average(pyramids);
        System.out.println("Base 1 Average = " + base1Average);

        double base1Median = getBase1Median(pyramids);
        System.out.println("Base 1 Median = " + base1Median);

        double base1LowerQuartile = getBase1LowerQuartile(pyramids);
        System.out.println("Base 1 Lower Quartile = " + base1LowerQuartile);
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

    public static double getBase1Median(List<Pyramid> pyramids){
        if(pyramids == null || pyramids.size() ==0)
            return 0;
        return getMedian(getBase1SortedList(pyramids));
    }

    public static double getBase1LowerQuartile(List<Pyramid> pyramids){
        if(pyramids == null || pyramids.size() == 0)
            return 0;
        List<Double> sortedBase1 = getBase1SortedList(pyramids);
        return getMedian(sortedBase1.stream().limit(sortedBase1.size()/2).collect(Collectors.toList()));
    }

    public static List<Double> getBase1SortedList(List<Pyramid> pyramids){
          return pyramids
                .stream()
                .map(Pyramid::getBase1)
                .sorted().collect(Collectors.toList());
    }

    public static double getMedian(List<Double> list){
        int length = list.size();

        if(length % 2 == 0)
            return (list.get(length / 2) + list.get((length / 2) + 1))/2;
        return list.get(length/2);
    }

}
