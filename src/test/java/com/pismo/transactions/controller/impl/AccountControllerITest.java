package com.pismo.transactions.controller.impl;

import com.pismo.transactions.constants.AccountType;
import com.pismo.transactions.exceptions.ResourceNotFoundException;
import com.pismo.transactions.mapper.AccountMapper;
import com.pismo.transactions.model.Account;
import com.pismo.transactions.model.dto.AccountResponse;
import com.pismo.transactions.repositories.AccountRepository;
import com.pismo.transactions.service.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@WebMvcTest(AccountControllerImpl.class)
@ExtendWith(MockitoExtension.class)
class AccountControllerITest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    AccountService accountService;
    @MockBean
    AccountRepository accountRepository;

    @MockBean
    AccountMapper accountMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void shouldCreateAnAccount() throws Exception {
        String request="""
                 { "id": 1,
                     "accountNumber":"100001",
                    "accountHolderName": "Atin",
                    "accountType": "CURRENT"}
                """;
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/accounts").contentType("application/json").content(request).accept("application/json")).andExpect(status().isCreated());
    }

    @Test
    void shouldThrowExceptionForMissingAccountNumber() throws Exception {
        String request="""
                 { "id": 1,
                    "accountHolderName": "Atin",
                    "accountType": "CURRENT"}
                """;
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/accounts").contentType("application/json").content(request).accept("application/json")).andExpect(status().is4xxClientError());
    }


    @Test
    void shouldFindAnAccount() throws Exception {
        String response= """
                 {
                 "id": 1,
                    "accountNumber": 10001,
                    "accountHolderName": "Atin",
                    "accountType": "CURRENT"
                    }
                """;
        Account account=Account.builder().accountType(AccountType.CURRENT).id(1L).accountHolderName("Atin").accountNumber(10001L).build();
        AccountResponse accountResponse = new AccountResponse(1L,10001L,"Atin",null, AccountType.CURRENT);
        Mockito.when(accountMapper.map(any(Account.class))).thenReturn(accountResponse);
        Mockito.when(accountRepository.findById(any())).thenReturn(Optional.ofNullable(account));
        Mockito.when(accountService.getAccount(any())).thenReturn(account);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/accounts/1")).andExpect(status().isOk()).andExpect(content().json(response));

    }

    @Test
    void shouldThrowAnExceptionFindAnAccount() throws Exception {
        String response= """
                 {
                 "id": 1,
                    "accountNumber": 10001,
                    "accountHolderName": "Atin",
                    "accountType": "CURRENT"
                    }
                """;

        AccountResponse accountResponse = new AccountResponse(1L,10001L,"Atin", LocalDateTime.now(), AccountType.CURRENT);
        Mockito.when(accountMapper.map(any(Account.class))).thenReturn(accountResponse);
        Mockito.when(accountRepository.findById(any())).thenThrow(ResourceNotFoundException.class);
        Mockito.when(accountService.getAccount(any())).thenThrow(ResourceNotFoundException.class);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/accounts/1")).andExpect(status().is4xxClientError());

    }
}