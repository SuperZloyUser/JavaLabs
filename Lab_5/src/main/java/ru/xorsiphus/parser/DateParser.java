package ru.xorsiphus.parser;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateParser
{
    public static boolean parseDate(String s) throws NumberFormatException
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);

        try
        {
            Date date = formatter.parse(s);

            var day = s.substring(0, 1);
            try
            {
                day += Integer.parseInt(s.substring(1, 2));
            } catch (Exception ignored)
            {
            }

            var month = "";
            try
            {
                month += Integer.parseInt(s.substring(2, 3));
            } catch (Exception ignored)
            {
            }

            try
            {
                month += Integer.parseInt(s.substring(3, 4));
            } catch (Exception ignored)
            {
            }

            try
            {
                month += Integer.parseInt(s.substring(4, 5));
            } catch (Exception ignored)
            {
            }

            return Integer.parseInt(day) <= 31 &&
                    Integer.parseInt(month) <= 12;
        } catch (ParseException e)
        {
//            e.printStackTrace();
            return false;
        }
    }

}
