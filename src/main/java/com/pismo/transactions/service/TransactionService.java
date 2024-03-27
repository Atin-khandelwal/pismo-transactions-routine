package com.pismo.transactions.service;

import com.pismo.transactions.exceptions.ResourceNotFoundException;
import com.pismo.transactions.model.Account;
import com.pismo.transactions.model.EvaluationType;
import com.pismo.transactions.model.Operation;
import com.pismo.transactions.model.Transaction;
import com.pismo.transactions.repositories.OperationRepository;
import com.pismo.transactions.repositories.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final OperationRepository operationRepository;
    private final AccountService accountService;
    public Transaction createTransaction(Transaction transaction) {
        Operation operation= operationRepository.findById(transaction.getOperationId()).orElseThrow(()->new ResourceNotFoundException("No operationId exists"));
        Account account= accountService.getAccount(transaction.getAccountId());
        //TODO: Below line of code can be replaced with Factory with strategy design pattern to avoid if else block
        if(operation.evaluationType().equals(EvaluationType.NEGATIVE))
           transaction.setAmount(transaction.getAmount().negate());
        transaction.setEventDate(LocalDateTime.now());
        return transactionRepository.save(transaction);
    }
}
