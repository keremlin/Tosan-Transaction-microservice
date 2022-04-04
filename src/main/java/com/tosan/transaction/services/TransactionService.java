package com.tosan.transaction.services;

import java.util.List;

import com.tosan.transaction.model.DepositTransaction;

public interface TransactionService {
    public abstract DepositTransaction registerTransaction(DepositTransaction transaction);
    public abstract List<DepositTransaction> getListOfTransaction(int depositNumber);
    public DepositTransaction getTransactionByNumber(int number);
}
