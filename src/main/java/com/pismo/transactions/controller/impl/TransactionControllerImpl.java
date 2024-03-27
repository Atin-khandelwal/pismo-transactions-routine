package com.pismo.transactions.controller.impl;

import com.pismo.transactions.controller.TransactionController;
import com.pismo.transactions.mapper.TransactionMapper;
import com.pismo.transactions.model.dto.CreateTransactionRequest;
import com.pismo.transactions.model.dto.TransactionResponse;
import com.pismo.transactions.service.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/transactions")
@RequiredArgsConstructor
public class TransactionControllerImpl implements TransactionController {

private  final TransactionService transactionService;
private final TransactionMapper mapper;


    @PostMapping
    public ResponseEntity<TransactionResponse> createTransaction(@Valid @RequestBody CreateTransactionRequest createTransactionRequest){
    return ResponseEntity.status(HttpStatus.CREATED).body(mapper.map(transactionService.createTransaction(mapper.map(createTransactionRequest))));
}


}
