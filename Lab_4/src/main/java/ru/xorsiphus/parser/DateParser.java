package ru.xorsiphus.parser;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateParser
{
    public static Date parseDate(String s) throws NumberFormatException
    {
        Date res;

        try
        {
            res = _parseDate(s);
        } catch (ParseException e)
        {
            res = new Date(0);
            System.out.println(e.getMessage());
        }

        return res;
    }

    private static Date _parseDate(String s) throws ParseException
    {
        SimpleDateFormat parser = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date dateStr;

        try
        {
            dateStr = parser.parse(s);
        } catch (ParseException e)
        {
            System.out.println(e.getMessage());
            dateStr = new PropertiesParser<Date>()
                    .hasMessage("Введите дату публикации(Day-Month-Year): ")
                    .hasParser(DateParser::parseDate)
                    .readCycle();
        }
        return new Date(dateStr.getTime());
    }
}
