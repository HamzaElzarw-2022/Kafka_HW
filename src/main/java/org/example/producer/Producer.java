package org.example.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.example.Message;
import org.example.MessageSerializer;

import java.util.Properties;

public class Producer {

    private final String TOPIC = "best-topic";
    private Properties props = new Properties();
    private String location = "https://localhost:9092";

    public Producer() {

        System.out.println("starting Producer.");

        props.put("client.id", "basic-producer");
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, location);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, MessageSerializer.class.getName());

    }

    public void produce(String key, Message value) {

        try(KafkaProducer<String, Message> producer = new KafkaProducer<>(props)) {
            System.out.println("sending record with key=" + key);
            producer.send(new ProducerRecord<>(TOPIC, key, value));

        } catch (Exception e) {
            throw e;
        }
    }

}

