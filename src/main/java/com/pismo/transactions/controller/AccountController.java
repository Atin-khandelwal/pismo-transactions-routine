package com.pismo.transactions.controller;

import com.pismo.transactions.exceptions.InvalidDataException;
import com.pismo.transactions.exceptions.ResourceNotFoundException;
import com.pismo.transactions.model.dto.AccountResponse;
import com.pismo.transactions.model.dto.CreateAccountRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "account-apis")
public interface AccountController {

  @Operation(summary = "Create an account")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "201", description = "Created", content =
                  { @Content(mediaType = "application/json", schema =
                  @Schema(implementation = AccountResponse.class)) }),

          @ApiResponse(responseCode = "412", description = "Account Number already exists",content =
                  { @Content(mediaType = "application/json", schema =
                  @Schema(implementation = InvalidDataException.class)) }),
          @ApiResponse(responseCode = "500", description = "Internal server error") })
  ResponseEntity<AccountResponse> createAccount(
      @RequestBody CreateAccountRequest createAccountRequest);

  @Operation(summary = "Get an account by accountId")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Ok", content =
                  { @Content(mediaType = "application/json", schema =
                  @Schema(implementation = AccountResponse.class)) }),
          @ApiResponse(responseCode = "404", description = "Requested account id is unavailable",content =
                  { @Content(mediaType = "application/json", schema =
                  @Schema(implementation = ResourceNotFoundException.class)) }),
          @ApiResponse(responseCode = "500", description = "Internal server error") })
  ResponseEntity<AccountResponse> getAccountById(Long accountId);
}
