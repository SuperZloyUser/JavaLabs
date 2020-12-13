package ru.xorsiphus.parser;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.sql.Date;

public class DateValidation implements ConstraintValidator<DateChecker, Date>
{
    @Override
    public void initialize(DateChecker constraintAnnotation)
    {

    }

    @Override
    public boolean isValid(Date date, ConstraintValidatorContext constraintValidatorContext)
    {
        return true;
    }
}
