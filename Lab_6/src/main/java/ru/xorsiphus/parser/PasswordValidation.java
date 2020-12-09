package ru.xorsiphus.parser;

import ru.xorsiphus.entity.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidation implements ConstraintValidator<PasswordChecker, User>
{

    @Override
    public void initialize(PasswordChecker constraintAnnotation)
    {

    }

    @Override
    public boolean isValid(User user, ConstraintValidatorContext constraintValidatorContext)
    {
        return user.getPassword().equals(user.getRepeat_password());
    }
}
