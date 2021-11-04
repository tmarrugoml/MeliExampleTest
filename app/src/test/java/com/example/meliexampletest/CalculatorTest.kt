package com.example.meliexampletest

import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class CalculatorTest {

    private lateinit var calculator: Calculator

    @Before
    fun setUp() {
        calculator = Calculator()
    }

    @After
    fun tearDown() {
        calculator.cleanState()
    }

    @Test
    fun add_positiveNumbers_check() {
        assertEquals(30, calculator.add(10, 20))
    }

    @Test
    fun add_negativeNumbers_check() {
        assertEquals(-30, calculator.add(-10, -20))
    }

    @Test
    fun add_negativeAndPositiveNumbers_check() {
        assertEquals(10, calculator.add(-10, 20))
    }

    @Test
    fun subtract_positiveNumbers_check() {
        assertEquals(3, calculator.subtract(7, 4))
    }

    @Test
    fun subtract_negativeNumbers_check() {
        assertEquals(10, calculator.subtract(-10, -20))
    }

    @Test
    fun subtract_negativeAndPositiveNumbers_check() {
        assertEquals(30, calculator.subtract(10, -20))
    }

    @Test
    fun objectNotNull() {
        assertNotNull("calculator debe estar inicializada", calculator)
    }
}
