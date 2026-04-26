package com.seminolestate;

public class App {

    public static void main(String[] args) {

        if (args.length > 0 && args[0].equalsIgnoreCase("fail")) {
            System.out.println("{\"level\":\"ERROR\",\"event\":\"simulated_failure\",\"message\":\"Application crash simulated for incident response demo\"}");
            throw new RuntimeException("Simulated application failure");
        }
        System.out.println("{\"level\":\"INFO\",\"event\":\"app_start\",\"message\":\"Application started\"}");

        int n = 10;

        if (args.length > 0) {
            try {
                n = Integer.parseInt(args[0]);
                System.out.println("{\"level\":\"INFO\",\"event\":\"input_received\",\"value\":" + n + "}");
            } catch (NumberFormatException e) {
                System.out.println("{\"level\":\"ERROR\",\"event\":\"invalid_input\",\"message\":\"Invalid number provided\"}");
                n = 10;
            }
        }

        long result = Fibonacci.fib(n);

        System.out.println("{\"level\":\"INFO\",\"event\":\"calculation_complete\",\"input\":" + n + ",\"result\":" + result + "}");
        System.out.println("{\"level\":\"INFO\",\"event\":\"app_shutdown\",\"message\":\"Application finished successfully\"}");
    }
}