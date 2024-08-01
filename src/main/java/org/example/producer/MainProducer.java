package org.example.producer;

import org.example.Message;

public class MainProducer {
    public static void main(String[] args) {
        System.out.println("program starter.");

        Producer producer = new Producer();

        producer.produce("m1", new Message(13, "fibPrime"));
        producer.produce("m2", new Message(7, "fibPrime"));
        producer.produce("m3", new Message(5, "fibPrime"));

        producer.produce("m4", new Message(13, "fib"));
        producer.produce("m5", new Message(5, "fib"));
        producer.produce("m6", new Message(1, "fib"));

        producer.produce("m7", new Message(20, "prime"));
        producer.produce("m8", new Message(7, "prime"));
        producer.produce("m9", new Message(3, "prime"));

    }
}