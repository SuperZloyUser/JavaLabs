package ru.xorsiphus.parser;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidation.class)
public @interface PasswordChecker
{
    String message() default "Пароли не совпадают!";
    Class<?>[] groups() default {};
    public abstract Class<? extends Payload>[] payload() default {};
}
