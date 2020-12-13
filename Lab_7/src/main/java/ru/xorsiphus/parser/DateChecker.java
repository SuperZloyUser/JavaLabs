package ru.xorsiphus.parser;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateValidation.class)
public @interface DateChecker
{
    String message() default "Пароли не совпадают!";
    Class<?>[] groups() default {};
    public abstract Class<? extends Payload>[] payload() default {};
}
