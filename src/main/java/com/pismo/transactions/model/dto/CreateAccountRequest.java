package com.pismo.transactions.model.dto;

import com.pismo.transactions.constants.AccountType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Schema(name = "account", description = "Account model")
public record CreateAccountRequest(
        @Schema(name = "Account Number ", description = "Unique account number assigned to each Account", example = "1000987333", type = "int64")
        @NotNull(message = "Account number is mandatory")
        Long accountNumber,
        @NotEmpty
        @Schema(name = "Account Holder Name", description = "Account Holder Name", example = "Renaldo", type = "string")
        String accountHolderName,
        @Schema(name = "Account Type", description = "Account Type", example = "SAVINGS")
        AccountType accountType)  {
}
