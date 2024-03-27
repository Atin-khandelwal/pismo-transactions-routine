package com.pismo.transactions.mapper;

import com.pismo.transactions.model.Account;
import com.pismo.transactions.model.dto.AccountResponse;
import com.pismo.transactions.model.dto.CreateAccountRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AccountMapper {
    AccountResponse map(Account account);
    Account map(CreateAccountRequest account);

}
