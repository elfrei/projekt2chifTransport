package vk_warehousing.transportAutragsErstellung.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class TimeUtil {
    
    public static int compareTime(String format, String t1, String t2)
            throws Exception
    {
        Date d1 = convertToDate(format, t1);
        Date d2 = convertToDate(format, t2);
        return d1.compareTo(d2);
    }
    
    public static Calendar convertToCalendaer(Date d)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        return c;
    }
    
    public static Date convertToDate(Calendar c)
    {
        return Calendar.getInstance().getTime();
    }

    public static String convertAsString(String format,
            Calendar calendar)
    {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(calendar.getTime());
    }
    public static String convertAsString(String format,
            Date date)
    {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }
    
    public static Calendar convertToCalendar(String format,
            String date)
            throws Exception
    {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Calendar c= convertToCalendaer(sdf.parse(date));
        return c;
    }
    
    public static Date convertToDate(String format,
            String date)
            throws Exception
    {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date d= sdf.parse(date);
        return d;
    }
    

}
