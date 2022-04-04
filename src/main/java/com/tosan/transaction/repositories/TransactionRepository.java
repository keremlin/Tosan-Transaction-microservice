package com.tosan.transaction.repositories;

import java.util.List;
import java.util.Optional;

import com.tosan.transaction.model.DepositTransaction;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<DepositTransaction,Integer> {
    List<DepositTransaction> findBySourceOrDestination(int deposit,int dest);
    Optional<DepositTransaction> findByNumber(int number);
}   
