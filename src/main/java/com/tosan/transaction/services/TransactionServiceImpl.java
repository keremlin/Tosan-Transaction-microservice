package com.tosan.transaction.services;

import java.util.List;


import com.tosan.transaction.exceptions.TransactionNotFoundException;
import com.tosan.transaction.model.DepositTransaction;
import com.tosan.transaction.repositories.TransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository repo;

    @Override
    @Transactional
    public DepositTransaction registerTransaction(DepositTransaction transaction) {
        return repo.save(transaction);
    }

    @Override
    public List<DepositTransaction> getListOfTransaction(int depositNumber) {
        return repo.findBySourceOrDestination(depositNumber, depositNumber);
    }

    @Override
    public DepositTransaction getTransactionByNumber(int number) {
        return repo.findByNumber(number)
                .orElseThrow(() -> new TransactionNotFoundException(number + ""));
    }

}
