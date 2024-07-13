package com.example.bankingapplicationsmalltodo.account.validate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

class AccountHolderNameValidator implements ConstraintValidator<AccountHolderNameValidate, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return validateAccountHolderName(value);
    }

    public boolean validateAccountHolderName(String accountHolderName) {
        //custom validation Account Holder Name
        return !accountHolderName.isEmpty();
    }
}
