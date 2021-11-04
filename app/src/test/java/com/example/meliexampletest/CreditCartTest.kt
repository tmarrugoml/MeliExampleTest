package com.example.meliexampletest

import junit.framework.Assert.*
import org.junit.After
import org.junit.Before
import org.junit.Test

//For  CHO WorkShop
class CreditCartTest {

    private lateinit var creditCard: CreditCard

    @Before
    fun setUp() {
        creditCard = CreditCard()
    }

    @After
    fun tearDown() {
        creditCard.cleanState()
    }

    @Test
    fun check_cvv_size_correct() {

        val result = creditCard.setCVV("123")

        assertTrue(result)
        assertNotNull(creditCard.cvv)
    }

    @Test(expected = IllegalArgumentException::class)
    fun check_cvv_size_incorrect() {

        val result = creditCard.setCVV("13")
        assertFalse(result)
    }

    @Test(expected = ClassCastException::class)
    fun check_cvv_character_not_numeric() {

        val result = creditCard.setCVV("1S2")
        assertFalse(result)
    }

    /** PROBLEMA 1
     * Validar MAX 16 dígitos
     * Validar que solo sean numéricos
     * Validar que el lo guardado en CreditCard.digit sea
       el formato: **** **** **** 1234 (siendo 1234 los ultimos dígitos de la tarjeta)
     **/

    /** PROBLEMA 2
     * Validar la fecha de expiracion con formato MM/yy
     * Validar el año sea mayor o igual al actual
     * Validar que el mes sea mayor que el actual
     **/
}
