package ru.xorsiphus.parser;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateParser
{
    public static java.sql.Date parseDate(String s) throws NumberFormatException
    {
        java.sql.Date res;

        try
        {
            res = _parseDate(s);
        } catch (ParseException e)
        {
            res = new java.sql.Date(0);
            System.out.println(e.getMessage());
        }

        return res;
    }

    private static java.sql.Date _parseDate(String s) throws ParseException
    {
        SimpleDateFormat parser = new SimpleDateFormat("dd-MM-yyyy");
        Date dateStr;

        try
        {
            dateStr = parser.parse(s);
        } catch (ParseException e)
        {
            dateStr = new Date(0);
            System.out.println(e.getMessage());
        }

        return new java.sql.Date(dateStr.getTime());
    }
}
