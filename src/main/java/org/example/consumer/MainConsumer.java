package org.example.consumer;

public class MainConsumer {
    public static void main(String[] args) throws Exception {
        System.out.println("program started");

        Consumer consumer = new Consumer();

        consumer.consume();
    }
}