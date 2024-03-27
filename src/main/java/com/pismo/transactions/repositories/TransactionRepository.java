package com.pismo.transactions.repositories;

import com.pismo.transactions.model.Transaction;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends ListCrudRepository<Transaction,Long> {
}
