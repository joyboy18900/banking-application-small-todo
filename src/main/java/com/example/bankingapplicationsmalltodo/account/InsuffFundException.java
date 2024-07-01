package com.example.bankingapplicationsmalltodo.account;

public class InsuffFundException extends RuntimeException {
    public InsuffFundException(String message) {
        super(message);
    }
}
