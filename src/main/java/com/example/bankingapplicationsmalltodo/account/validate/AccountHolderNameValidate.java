package com.example.bankingapplicationsmalltodo.account.validate;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = AccountHolderNameValidator.class)
@Documented
public @interface AccountHolderNameValidate {

    String message() default "invalid Account Holder Name or it is empty.";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}