package com.tosan.transaction.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaProducer {

    public static final String TOPIC = "transactions";
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    private KafkaTemplate<String, KafkaDTO> objectKafkaTemplate;

    public void sendMessage(KafkaDTO message) {
        log.info("the message in object is : {}",message);
        for(int i=0;i<100;i++) {
            //message.(""+i);
            var future = objectKafkaTemplate.send("transactions",i+"", message);
            future.whenComplete((x, y) -> {
                log.info("message : {} --> partirion : {}",x.getRecordMetadata().timestamp(), x.getRecordMetadata().partition());
            });
        }
    }

    public void sendMessage(String msg) {

        var future = kafkaTemplate.send("transactions", msg);
        future.whenComplete((x, y) -> {
            log.info("The message is sent successfully : {} , {}", x.toString(), y.toString());
            return;
        });
        log.info("Message was not sent");
    }
}
