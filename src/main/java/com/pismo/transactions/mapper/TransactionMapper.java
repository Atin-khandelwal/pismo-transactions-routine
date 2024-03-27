package com.pismo.transactions.mapper;

import com.pismo.transactions.model.Transaction;
import com.pismo.transactions.model.dto.CreateTransactionRequest;
import com.pismo.transactions.model.dto.TransactionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TransactionMapper {

    Transaction map(CreateTransactionRequest createTransactionRequest);
    TransactionResponse map(Transaction transactionResource);


}
