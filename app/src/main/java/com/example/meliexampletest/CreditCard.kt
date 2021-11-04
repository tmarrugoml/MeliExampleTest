package com.example.meliexampletest

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import org.joda.time.format.DateTimeFormatter

class CreditCard {

    var cvv: Int? = null
        private set

    var digits: String? = null
        private set

    var expirationDate: String? = null
        private set

    init {
        println("init CreditCard - done! $this")
    }

    fun cleanState() {
        println("clean state - done! $this")
    }

    fun setCVV(securityCode: String): Boolean {

        if (securityCode.length != CVV_SIZE)
            throw IllegalArgumentException("Debe contener tres caracteres")

        val numbers = securityCode.toIntOrNull()
            ?: throw ClassCastException("Solo debe insertar datos numéricos")

        this.cvv = numbers

        return cvv != null
    }

    fun setDigits(value: String): Boolean {
        if (value.length != DIGITS_SIZE)
            throw IllegalArgumentException("Debe contener 16 caracteres")

        value.toLongOrNull()
            ?: throw ClassCastException("Solo debe insertar datos numéricos")

        digits = FORMAT.substring(0, 15) + value.substring(12)

        return digits != null
    }

    fun setExpirationDate(date: String): Boolean {

        val dtfOut: DateTimeFormatter = DateTimeFormat.forPattern("MM/yy")

        val value = dtfOut.parseDateTime(date)

        val today = DateTime.now()

        if (value.year().get() < today.year().get())
            throw IllegalArgumentException("El año debe ser superior o igual al actual")

        if (value.monthOfYear().get() <= today.monthOfYear().get())
            throw IllegalArgumentException("El mes debe ser superior al actual")

        expirationDate = dtfOut.print(value)

        return expirationDate != null
    }

    companion object {
        const val FORMAT = "**** **** **** ****"
        const val DIGITS_SIZE = 16
        const val CVV_SIZE = 3
    }
}
