package com.pismo.transactions.model;

import com.pismo.transactions.constants.OperationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Builder
@Data
@Table(name = "TRANSACTIONS")
public class Transaction {
    @Id
    private  String id;
    private  Long accountId;
    private LocalDateTime eventDate;
    private  Long operationId;
    private  BigDecimal amount;

}
