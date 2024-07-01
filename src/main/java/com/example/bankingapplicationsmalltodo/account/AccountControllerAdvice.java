package com.example.bankingapplicationsmalltodo.account;

import com.example.bankingapplicationsmalltodo.errors.MyError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AccountControllerAdvice {

    @ExceptionHandler(DuplicateHolderNameException.class)
    public ResponseEntity<MyError> duplicateHolderNameHandler(DuplicateHolderNameException e) {
        MyError error = new MyError();
        error.setCode("24000");
        error.setDescription("Holder name duplicated");
        error.setStatus(false);
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<MyError> accountNotFoundHandler(AccountNotFoundException e) {
        MyError error = new MyError();
        error.setCode("25000");
        error.setDescription("Account not found");
        error.setStatus(false);
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(InsuffFundException.class)
    public ResponseEntity<MyError> insuffFundHandler(InsuffFundException e) {
        MyError error = new MyError();
        error.setCode("26000");
        error.setDescription("Insufficient funds");
        error.setStatus(false);
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }
}
