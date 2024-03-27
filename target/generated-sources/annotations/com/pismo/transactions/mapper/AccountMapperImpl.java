package com.pismo.transactions.mapper;

import com.pismo.transactions.constants.AccountType;
import com.pismo.transactions.model.Account;
import com.pismo.transactions.model.dto.AccountResponse;
import com.pismo.transactions.model.dto.CreateAccountRequest;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-27T15:20:54+0530",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class AccountMapperImpl implements AccountMapper {

    @Override
    public AccountResponse map(Account account) {
        if ( account == null ) {
            return null;
        }

        Long id = null;
        Long accountNumber = null;
        String accountHolderName = null;
        LocalDateTime createdAt = null;
        AccountType accountType = null;

        id = account.getId();
        accountNumber = account.getAccountNumber();
        accountHolderName = account.getAccountHolderName();
        createdAt = account.getCreatedAt();
        accountType = account.getAccountType();

        AccountResponse accountResponse = new AccountResponse( id, accountNumber, accountHolderName, createdAt, accountType );

        return accountResponse;
    }

    @Override
    public Account map(CreateAccountRequest account) {
        if ( account == null ) {
            return null;
        }

        Account.AccountBuilder account1 = Account.builder();

        account1.accountNumber( account.accountNumber() );
        account1.accountHolderName( account.accountHolderName() );
        account1.accountType( account.accountType() );

        return account1.build();
    }
}
