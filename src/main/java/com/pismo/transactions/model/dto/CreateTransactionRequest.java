package com.pismo.transactions.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(name = "transaction", description = "Transaction  model")
public record CreateTransactionRequest(
        @NotNull(message = "AccountId should be present")
        @Schema(name = "accountId", description = "Account Id for particular document", example = "1", type = "int64")
        Long accountId,
        @NotNull(message = "OperationId should be present")
        @Schema(name = "eventDate", description = "OperationId for the amount evaluation", example = "1", type = "int64")
        Long operationId,
        @DecimalMin(value = "0.0", inclusive = false)
        @Schema(name = "amount", description = "Transactional amount", example = "1.0", type = "double",minContains = 1)
        BigDecimal amount) {
}
