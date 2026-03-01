package com.seminolestate;

public final class Fibonacci {
    private Fibonacci() {}

    // Fast + safe for small n (good for demo)
    public static long fib(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be >= 0");
        if (n <= 1) return n;

        long a = 0;
        long b = 1;

        for (int i = 2; i <= n; i++) {
            long next = a + b;
            a = b;
            b = next;
        }
        return b;
    }
}
