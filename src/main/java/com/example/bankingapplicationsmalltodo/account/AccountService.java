package com.example.bankingapplicationsmalltodo.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(AccountRequest accountRequest) {
        List<Account> results = accountRepository.findByAccountHolderName(accountRequest.getAccountHolderName().trim());
        if(results != null && results.size() > 0) {
            throw new DuplicateHolderNameException("");
        }
        Account account = new Account(null, accountRequest.getAccountHolderName(), accountRequest.getBalance());
        return accountRepository.save(account);
    }

    public Optional<Account> getAccount(Long id) {
        return accountRepository.findById(id);
    }

    public Account deposit(Long id, double amount) {
        Account account = getAccount(id).orElseThrow(() -> new AccountNotFoundException(""));
        account.setBalance(account.getBalance() + amount);
        return accountRepository.save(account);
    }

    public Account withdraw(Long id, double amount) {
        Account account = getAccount(id).orElseThrow(() -> new AccountNotFoundException(""));
        if (account.getBalance() < amount) {
            throw new InsuffFundException("");
        }
        account.setBalance(account.getBalance() - amount);
        return accountRepository.save(account);
    }
}
