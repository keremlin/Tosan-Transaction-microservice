package com.tosan.transaction.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.tosan.transaction.model.*;

import org.springframework.beans.BeanUtils;

import lombok.Data;

@Data
public class TransactionDto {

    int id;

    @Min(1)
    @Max(Integer.MAX_VALUE)
    int transactionAmount;

    @NotNull
    TransactionStatus status;

    @NotNull
    TransactionType type;

    @Min(10000)
    @Max(99999)
    int source;

    @Min(10000)
    @Max(99999)
    int destination;

    String description = "";

    public DepositTransaction convert() {
        DepositTransaction temp = new DepositTransaction();
        BeanUtils.copyProperties(this, temp);
        return temp;
    }
}
