package com.tosan.transaction;

import static org.junit.jupiter.api.Assertions.*;

import com.tosan.transaction.model.DepositTransaction;
import com.tosan.transaction.model.TransactionType;
import com.tosan.transaction.model.TransactionStatus;
import com.tosan.transaction.services.generateRandom;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class generateRandomNumber {
    
    @Test
    void checkRandomTransactionNumber(){
        
        int case1=generateRandom.generateRandomTransactionNumber();
        int case2=generateRandom.generateRandomTransactionNumber();

        assertTrue(case1 >= 10000);
        assertTrue(case1 < 99999);
        assertTrue(case1 != case2);
    }

    @Test
    void checkTransactionObjectRandomNumber(){
        // DepositTransaction testCase=new DepositTransaction(0,null,198,TransactionStatus.successful,TransactionType.transfer,10009,10008,0,"this");
        DepositTransaction testCase=new DepositTransaction();
        assertTrue(testCase.getNumber()>0);
    }
}
