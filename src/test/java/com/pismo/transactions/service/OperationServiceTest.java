package com.pismo.transactions.service;

import com.pismo.transactions.model.EvaluationType;
import com.pismo.transactions.model.Operation;
import com.pismo.transactions.repositories.OperationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

        import static org.mockito.Mockito.times;
        import static org.mockito.Mockito.verify;
        import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class OperationServiceTest {


    @Mock
    OperationRepository operationRepository;

    @Test
    void shouldFindOperationId() {
        when(operationRepository.findById(any())).thenReturn(
                Optional.of(new Operation(2L, "Withdrawal", EvaluationType.NEGATIVE)));
        Operation operation = this.operationRepository.findById(2L).get();
        assertEquals(2L, operation.id());
        assertEquals("Withdrawal", operation.description());
        verify(this.operationRepository, times(1)).findById(any());
    }


}
