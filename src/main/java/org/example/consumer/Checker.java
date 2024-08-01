package org.example.consumer;

import org.example.Message;

public class Checker {

    static boolean isPerfectSquare(int num)
    {
        int s = (int) Math.sqrt(num);
        return (s*s == num);
    }

    // Returns true if n is a Fibonacci Number, else false
    static boolean isFibonacci(int num)
    {
        // n is Fibonacci if one of 5*n*n + 4 or 5*n*n - 4 or both
        // is a perfect square
        return isPerfectSquare(5*num*num + 4) ||
                isPerfectSquare(5*num*num - 4);
    }

    static  boolean isPrime(int num)
    {
        if(num<=1)
        {
            return false;
        }
        for(int i=2;i<=num/2;i++)
        {
            if((num%i)==0)
                return  false;
        }
        return true;
    }

    static boolean isBoth(int num) {
        return (isPrime(num) && isFibonacci(num));
    }

    static boolean checkMessage(Message message) throws Exception {

        return switch (message.getOperation()) {
            case "fibPrime" -> isBoth(message.getOperand());
            case "fib"      -> isFibonacci(message.getOperand());
            case "prime"    -> isPrime(message.getOperand());
            default         -> throw new Exception();
        };
    }



}
