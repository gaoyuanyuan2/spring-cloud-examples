package com.yan.kafka.controller;

import com.yan.kafka.stream.producer.MessageProducerBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yan on  08/10/2018.
 */
@RestController
public class KafkaController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private MessageProducerBean messageProducerBean;

    @Value("${kafka.topic}")
    private String topic;

    @PostMapping("/kafka/send")
    public Boolean send(@RequestParam String message) {
        kafkaTemplate.send(topic, message);
        return true;
    }

    @PostMapping("/stream/send")
    public Boolean streamSend(@RequestParam String message) {
        messageProducerBean.send(message);
        return true;
    }

    @PostMapping("/stream/my/send")
    public Boolean streamMySend(@RequestParam String message) {
        messageProducerBean.mySend(message);
        return true;
    }
}
