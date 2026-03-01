package com.seminolestate;

public class App {
    public static void main(String[] args) {
        int n = 10;
        if (args.length > 0) {
            try {
                n = Integer.parseInt(args[0]);
            } catch (NumberFormatException ignored) {
                System.out.println("Invalid number provided. Using default n=10.");
            }
        }

        System.out.println("=== Midterm Pipeline Demo App (Demo) ===");
        System.out.println(BuildInfo.summary());
        System.out.println("Fibonacci(" + n + ") = " + Fibonacci.fib(n));
        System.out.println("================================");
    }
}