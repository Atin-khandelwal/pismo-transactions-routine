package com.pismo.transactions.repositories;

import com.pismo.transactions.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;

public interface AccountRepository extends ListCrudRepository<Account,Long> {
}
