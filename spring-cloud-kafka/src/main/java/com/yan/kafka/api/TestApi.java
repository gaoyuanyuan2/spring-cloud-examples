package com.yan.kafka.api;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by yan on  08/10/2018.
 * API 测试
 */
public class TestApi {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "192.168.100.10:3181");
        properties.setProperty("key.serializer", StringSerializer.class.getName());
        properties.setProperty("vale.serializer", StringSerializer.class.getName());
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer(properties);
        String topic = "test";
        Integer partition = 0;
        Long timestamp = System.currentTimeMillis();
        String key = "message-key";
        String value = "Hello!";
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>(topic, partition, timestamp, key, value);
        Future<RecordMetadata> recordMetadata = kafkaProducer.send(producerRecord);
        RecordMetadata record = recordMetadata.get();
        System.out.println(record);
    }

}
