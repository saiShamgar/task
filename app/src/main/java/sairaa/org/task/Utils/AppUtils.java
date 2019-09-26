package sairaa.org.task.Utils;

import android.app.DatePickerDialog;
import android.content.Context;
import android.util.Log;
import android.widget.DatePicker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
