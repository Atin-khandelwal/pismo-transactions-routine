package com.pismo.transactions.controller;

import com.pismo.transactions.exceptions.ResourceNotFoundException;
import com.pismo.transactions.model.dto.CreateTransactionRequest;
import com.pismo.transactions.model.dto.TransactionResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "transaction-apis")
public interface TransactionController {

  @Operation(summary = "Generate a new transaction")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "201", description = "Ok", content =
                  { @Content(mediaType = "application/json", schema =
                  @Schema(implementation = TransactionResponse.class)) }),
          @ApiResponse(responseCode = "404", description = "Requested account id is unavailable",content =
                  { @Content(mediaType = "application/json", schema =
                  @Schema(implementation = ResourceNotFoundException.class)) }),
          @ApiResponse(responseCode = "500", description = "Internal server error") })
  ResponseEntity<TransactionResponse> createTransaction(CreateTransactionRequest transactionRequest);
}
