package com.tosan.transaction.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.tosan.transaction.services.generateRandom;

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
