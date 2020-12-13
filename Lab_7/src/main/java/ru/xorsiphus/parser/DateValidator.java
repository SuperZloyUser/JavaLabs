package ru.xorsiphus.parser;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateValidator implements ConstraintValidator<DateChecker, String>
{

    @Override
    public void initialize(DateChecker constraintAnnotation)
    {

    }

    @Override
    public boolean isValid(String date, ConstraintValidatorContext constraintValidatorContext)
    {
        return DateParser.parseDate(date);
    }
}
