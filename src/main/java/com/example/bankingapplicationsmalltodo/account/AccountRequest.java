package com.example.bankingapplicationsmalltodo.account;

import com.example.bankingapplicationsmalltodo.account.validate.AccountHolderNameValidate;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public class AccountRequest {

//    @AccountHolderNameValidate
    @NotEmpty
    private String accountHolderName;

    @Min(0)
    @Max(100000)
    private Double balance;

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
