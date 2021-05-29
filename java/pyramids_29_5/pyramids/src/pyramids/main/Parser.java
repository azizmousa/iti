package pyramids.main;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class Parser {

    public static int parseToInt(String num){
        if(num == null || num.equals(""))
            return 0;
        return Integer.parseInt(num);
    }

    public static double parseToDouble(String num) throws ParseException {
        if(num == null || num.equals("") || num.equals(" "))
            return 0;
        NumberFormat format = NumberFormat.getInstance(Locale.GERMAN);
        return format.parse(num).doubleValue();
    }

}
