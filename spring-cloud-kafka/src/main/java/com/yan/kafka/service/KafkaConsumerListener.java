package com.yan.kafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Created by yan on  08/10/2018.
 */
@Service
public class KafkaConsumerListener {
    @KafkaListener(topics = "${kafka.topic}")
    public void onMessage(String message) {
        System.out.println("收到的消息：" + message);
    }

    @KafkaListener(topics = "test")
    public void onMyMessage(String message) {
        System.out.println("收到的消息：" + message);
    }

}
