package com.tosan.transaction.kafka;

import com.tosan.transaction.dto.TransactionDto;
import com.tosan.transaction.services.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    @Autowired
    private TransactionService service;

    @KafkaListener(topics = "transactions")
    public void receiveAndCommitTransactions(ConsumerRecord<String, TransactionDto> message) {
        log.info("Received transaction is  : {}", message);
        service.registerTransaction(message.value().convert());
        log.info("Received transaction is committed : {}", message);
    }
}

