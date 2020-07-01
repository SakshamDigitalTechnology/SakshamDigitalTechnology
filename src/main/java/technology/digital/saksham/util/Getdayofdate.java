package technology.digital.saksham.util;

import java.util.Calendar;
import java.util.Date;

public class Getdayofdate {


    public static int getDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_MONTH);
    }


}
