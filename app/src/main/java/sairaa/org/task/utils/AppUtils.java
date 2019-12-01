package sairaa.org.task.utils;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AppUtils {


    public static String covertGSTTonormalDateFormat(String timeStamp){
        SimpleDateFormat input = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
        SimpleDateFormat output = new SimpleDateFormat("YYYY/dd/MM");
        Date d = null;
        try
        {
            d = input.parse(timeStamp);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        String formatted = output.format(d);
        Log.i("DATE", "" + formatted);
        return formatted;
    }
}
