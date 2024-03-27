package com.pismo.transactions.service;

import com.pismo.transactions.exceptions.ResourceNotFoundException;
import com.pismo.transactions.model.Account;
import com.pismo.transactions.repositories.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
      public Account createAccount(Account account){
          account.setCreatedAt(LocalDateTime.now());
          return accountRepository.save(account);
      }

    public Account getAccount(Long accountId) {
        return accountRepository.findById(accountId).orElseThrow(()-> new ResourceNotFoundException("Requested account id is unavailable"));
    }
}
