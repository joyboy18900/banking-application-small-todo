package com.example.bankingapplicationsmalltodo.account;

public class DuplicateHolderNameException extends RuntimeException {
    public DuplicateHolderNameException(String message) {
        super(message);
    }
}
