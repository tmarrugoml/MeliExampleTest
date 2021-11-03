package com.example.meliexampletest


import org.junit.Assert.*

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class CalculatorTest {
var calculator= Calculator()
    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
        
    }
    @Test
    fun add2() {

        assertEquals(30,10+20)
    }
    @Test
    fun add() {

        assertEquals(30,calculator.add(10,20))
    }
    @Test
    fun substract() {

        assertEquals(3,calculator.substract(7,4))
    }
    @Test
    fun substract2() {
        assertEquals(-10,calculator.substract(10,20))
    }

   @Test
    fun objectNotNull() {
        assertNotNull("calculator debe estar inicializada", calculator)
 }

}