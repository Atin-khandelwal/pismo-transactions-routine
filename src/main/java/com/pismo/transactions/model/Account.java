package com.pismo.transactions.model;

import com.pismo.transactions.constants.AccountType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Data
@Builder
@Table(name = "ACCOUNTS")
public class Account {
    @Id
    private  Long id;
    private  Long accountNumber;
    private  String accountHolderName;
    private  LocalDateTime createdAt;
    private  AccountType accountType;
}
