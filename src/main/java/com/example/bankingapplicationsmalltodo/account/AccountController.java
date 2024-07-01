package com.example.bankingapplicationsmalltodo.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountResponse> createAccount(@RequestBody AccountRequest accountRequest) {
        Account account = accountService.createAccount(accountRequest);

        List<Account> accountList = new ArrayList<>();
        accountList.add(new Account(account.getId(), account.getAccountHolderName(), account.getBalance()));

        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setCode(String.valueOf(HttpStatus.CREATED.value()));
        accountResponse.setAccountList(accountList);
        accountResponse.setStatus(true);

        return new ResponseEntity<>(accountResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountResponse> getAccount(@PathVariable Long id) {
        Account account = accountService.getAccount(id).orElseThrow(() -> new RuntimeException("Account not found"));

        List<Account> accountList = new ArrayList<>();
        accountList.add(new Account(account.getId(), account.getAccountHolderName(), account.getBalance()));

        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setCode(String.valueOf(HttpStatus.OK.value()));
        accountResponse.setAccountList(accountList);
        accountResponse.setStatus(true);

        return new ResponseEntity<>(accountResponse, HttpStatus.OK);
    }

    @PostMapping("/{id}/deposit")
    public ResponseEntity<AccountResponse> deposit(@PathVariable Long id, @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        Account account = accountService.deposit(id, amount);

        List<Account> accountList = new ArrayList<>();
        accountList.add(new Account(account.getId(), account.getAccountHolderName(), account.getBalance()));

        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setCode(String.valueOf(HttpStatus.OK.value()));
        accountResponse.setAccountList(accountList);
        accountResponse.setStatus(true);

        return new ResponseEntity<>(accountResponse, HttpStatus.OK);
    }

    @PostMapping("/{id}/withdraw")
    public ResponseEntity<AccountResponse> withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        Account account = accountService.withdraw(id, amount);

        List<Account> accountList = new ArrayList<>();
        accountList.add(new Account(account.getId(), account.getAccountHolderName(), account.getBalance()));

        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setCode(String.valueOf(HttpStatus.OK.value()));
        accountResponse.setAccountList(accountList);
        accountResponse.setStatus(true);

        return new ResponseEntity<>(accountResponse, HttpStatus.OK);
    }
}
