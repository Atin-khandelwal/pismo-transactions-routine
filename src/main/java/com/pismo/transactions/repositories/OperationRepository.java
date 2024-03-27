package com.pismo.transactions.repositories;

import com.pismo.transactions.model.Operation;
import org.springframework.data.repository.ListCrudRepository;

public interface OperationRepository extends ListCrudRepository<Operation,Long> {
}
