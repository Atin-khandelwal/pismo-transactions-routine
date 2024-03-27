package com.pismo.transactions.controller.impl;

import com.pismo.transactions.exceptions.ResourceNotFoundException;
import com.pismo.transactions.mapper.AccountMapper;
import com.pismo.transactions.mapper.TransactionMapper;
import com.pismo.transactions.repositories.AccountRepository;
import com.pismo.transactions.repositories.TransactionRepository;
import com.pismo.transactions.service.AccountService;
import com.pismo.transactions.service.TransactionService;
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

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@AutoConfigureMockMvc
@WebMvcTest(TransactionControllerImpl.class)
@ExtendWith(MockitoExtension.class)
class TransactionControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    TransactionService transactionService;
    @MockBean
    TransactionRepository transactionRepository;
    @MockBean
    AccountService accountService;

    @MockBean
    TransactionMapper mapper;


    @Test
    void shouldCreateTransaction() throws Exception {
        String request="""
                 {
                    "amount":10.0,
                                                     "accountId":1,
                                                     "operationId":1
                                             }
                """;
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/transactions").contentType("application/json").content(request).accept("application/json")).andExpect(status().isCreated());
    }
    @Test
    void shouldThrowAnErrorInCaseOfMissingAccountId() throws Exception {
        String request="""
                 {
                    "amount":10.0,

                                                     "operationId":1
                                             }
                """;
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/transactions").contentType("application/json").content(request).accept("application/json")).andExpect(status().is4xxClientError());
    }

    @Test
    void shouldThrowAnErrorInCaseOfWrongAmount() throws Exception {
        String request="""
                 {
                    "amount":-1.0, "accountId":1, "operationId":1
                                             }
                """;
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/transactions").contentType("application/json").content(request).accept("application/json")).andExpect(status().is4xxClientError());
    }

}