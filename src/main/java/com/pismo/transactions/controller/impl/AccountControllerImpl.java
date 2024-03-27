package com.pismo.transactions.controller.impl;

import com.pismo.transactions.controller.AccountController;
import com.pismo.transactions.mapper.AccountMapper;
import com.pismo.transactions.model.dto.AccountResponse;
import com.pismo.transactions.model.dto.CreateAccountRequest;
import com.pismo.transactions.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/accounts")
@RequiredArgsConstructor
public class AccountControllerImpl implements AccountController {

    private final AccountService accountService;
    @Autowired
    private final AccountMapper mapper;

    @PostMapping
    public ResponseEntity<AccountResponse> createAccount(@RequestBody @Validated CreateAccountRequest account){
       return ResponseEntity.status(HttpStatus.CREATED).body(mapper.map(accountService.createAccount(mapper.map(account))));
    }


    @GetMapping("/{id}")
    public ResponseEntity<AccountResponse> getAccountById(@PathVariable Long id){
          return ResponseEntity.ok(mapper.map(accountService.getAccount(id)));
    }
}
