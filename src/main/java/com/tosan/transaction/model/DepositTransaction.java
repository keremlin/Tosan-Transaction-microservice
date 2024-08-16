package com.tosan.transaction.model;

import java.util.Date;



import com.tosan.transaction.services.generateRandom;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class DepositTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    Date transactionTime = new Date();

    int transactionAmount;

    TransactionStatus status;

    TransactionType type;

    int source;

    int destination;

    int number = generateRandom.generateRandomTransactionNumber();

    String description;

}
