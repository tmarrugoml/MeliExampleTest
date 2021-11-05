package com.example.meliexampletest

import org.junit.After
import org.junit.Assert.*
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

    @Test
    fun check_digits_size_correct() {

        val result = creditCard.setDigits("1234567891234567")

        assertTrue(result)
        assertNotNull(creditCard.digits)
    }

    @Test(expected = IllegalArgumentException::class)
    fun check_digits_size_incorrect() {

        val result = creditCard.setDigits("123456789")

        assertFalse(result)
        assertNull(creditCard.digits)
    }

    @Test(expected = ClassCastException::class)
    fun check_digits_digit_not_numeric() {

        val result = creditCard.setDigits("123456S1222AA451")

        assertFalse(result)
        assertNull(creditCard.digits)
    }

    @Test
    fun check_digits_format_correct() {

        val input = "1234567891234567"
        val expected = "**** **** **** 4567"
        val result = creditCard.setDigits(input)

        assertTrue(result)
        assertEquals(expected, creditCard.digits)
    }

    /** PROBLEMA 2
     * Validar la fecha de expiracion con formato MM/YY
     * Validar la fecha sea mayor que la actual
     **/

    @Test
    fun check_expirationDate_correct() {

        val result = creditCard.setExpirationDate("12/21")

        assertTrue(result)
        assertNotNull(creditCard.expirationDate)
    }

    @Test(expected = IllegalArgumentException::class)
    fun check_expirationDate_incorrect() {

        val result = creditCard.setExpirationDate("11/21")

        assertFalse(result)
        assertNull(creditCard.expirationDate)
    }

    @Test(expected = IllegalArgumentException::class)
    fun check_expirationDate_format_incorrect() {

        val result = creditCard.setExpirationDate("111/24")

        assertFalse(result)
        assertNull(creditCard.expirationDate)
    }
}
