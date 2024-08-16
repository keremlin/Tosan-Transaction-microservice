package com.tosan.transaction.controller;

import java.util.List;



import com.tosan.transaction.dto.TransactionDto;
import com.tosan.transaction.dto.depositNumberDto;
import com.tosan.transaction.kafka.KafkaProducer;
import com.tosan.transaction.kafka.KafkaDTO;
import com.tosan.transaction.model.DepositTransaction;
import com.tosan.transaction.services.TransactionService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transaction")
@Slf4j
public class TransactionController {

    @Autowired
    private TransactionService service;

    @PostMapping("/save")
    public ResponseEntity<DepositTransaction> save(@Valid @RequestBody TransactionDto transaction) {

        return ResponseEntity.ok().body(
                service.registerTransaction(transaction.convert()));
    }

    @PostMapping("/listOfTransactions")
    public ResponseEntity<List<DepositTransaction>> list(@Valid @RequestBody depositNumberDto depositNumber) {
        return ResponseEntity.ok().body(
                service.getListOfTransaction(depositNumber.getDepositNumber()));
    }

    @GetMapping("/{number}/transactionByNumber")
    public ResponseEntity<DepositTransaction> getTransactionByNumber(@PathVariable int number) {
        if (number > 10000)
            return ResponseEntity.ok().body(
                    service.getTransactionByNumber(number));
        else
            return ResponseEntity.badRequest().body(null);
    }
    @Autowired
    private KafkaProducer sender;
    @GetMapping("/{message}/send")
    public String send(@PathVariable String  message){
        sender.sendMessage(message);
        return "sent";
    }
    @PostMapping("/sendObject")
    public String sendit(@RequestBody KafkaDTO message){
        log.info("the message in object in controller is : {}",message);
        sender.sendMessage(message);
        return "Success";
    }
}
