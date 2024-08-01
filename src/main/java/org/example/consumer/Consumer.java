package org.example.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.example.Message;
import org.example.MessageDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

import static org.example.consumer.Checker.checkMessage;

public class Consumer {
    private final String TOPIC = "best-topic";
    private Properties props = new Properties();
    private String location = "https://localhost:9092";

    public Consumer() {
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "basic-consumer");
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, location);
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, MessageDeserializer.class.getName());
    }

    public void consume() throws Exception {

        try(KafkaConsumer<String, Message> consumer = new KafkaConsumer<>(props)) {

            consumer.subscribe(Collections.singletonList(TOPIC));

            System.out.println("listening on best-topic...");

            while(true) {
                ConsumerRecords<String, Message> records = consumer.poll(Duration.ofMillis(100));

                for (ConsumerRecord<String, Message> record : records) {
                    System.out.printf("key=%s, value = %s%n", record.key(), record.value());
                    System.out.println(checkMessage(record.value()));
                }
            }

        }

    }
}
