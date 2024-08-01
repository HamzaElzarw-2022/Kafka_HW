package org.example;

public class Message {

    private int operand;
    private String operation;

    public Message(int operand, String operation) {
        this.operand = operand;
        this.operation = operation;
    }

    public Message() {
    }

    public int getOperand() {
        return operand;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperand(int operand) {
        this.operand = operand;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "Message{" +
                "operand=" + operand +
                ", operation='" + operation + '\'' +
                '}';
    }
}
