package ru.xorsiphus.parser;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.sql.Date;

@Service
public class DateValidator implements Validator
{
    @Override
    public boolean supports(Class<?> aClass)
    {
        return Date.class.equals(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors)
    {
        var temp = (String) obj;
        if (DateParser.parseDate(temp).equals(new Date(1337)))
        {
            errors.rejectValue("Date", "value.negative");
        }
    }
}
