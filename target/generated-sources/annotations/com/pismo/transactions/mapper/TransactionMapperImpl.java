package com.pismo.transactions.mapper;

import com.pismo.transactions.model.Transaction;
import com.pismo.transactions.model.dto.CreateTransactionRequest;
import com.pismo.transactions.model.dto.TransactionResponse;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-27T15:20:54+0530",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class TransactionMapperImpl implements TransactionMapper {

    @Override
    public Transaction map(CreateTransactionRequest createTransactionRequest) {
        if ( createTransactionRequest == null ) {
            return null;
        }

        Transaction.TransactionBuilder transaction = Transaction.builder();

        transaction.accountId( createTransactionRequest.accountId() );
        transaction.operationId( createTransactionRequest.operationId() );
        transaction.amount( createTransactionRequest.amount() );

        return transaction.build();
    }

    @Override
    public TransactionResponse map(Transaction transactionResource) {
        if ( transactionResource == null ) {
            return null;
        }

        Long id = null;
        Long accountId = null;
        LocalDateTime eventDate = null;
        Long operationId = null;
        BigDecimal amount = null;

        if ( transactionResource.getId() != null ) {
            id = Long.parseLong( transactionResource.getId() );
        }
        accountId = transactionResource.getAccountId();
        eventDate = transactionResource.getEventDate();
        operationId = transactionResource.getOperationId();
        amount = transactionResource.getAmount();

        TransactionResponse transactionResponse = new TransactionResponse( id, accountId, eventDate, operationId, amount );

        return transactionResponse;
    }
}
