package com.seminolestate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @Test
    void fibBaseCases() {
        assertEquals(0, Fibonacci.fib(0));
        assertEquals(1, Fibonacci.fib(1));
    }

    @Test
    void fibTypicalValues() {
        assertEquals(55, Fibonacci.fib(10));
    }

    @Test
    void fibRejectsNegative() {
        assertThrows(IllegalArgumentException.class, () -> Fibonacci.fib(-1));
    }
}