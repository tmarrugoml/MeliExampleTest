package com.example.meliexampletest

class Calculator {

    init {
        println("init calculator - done!")
    }

    fun add(numberOne: Int, numberTwo: Int): Int {
        return numberOne + numberTwo
    }

    fun subtract(numberOne: Int, numberTwo: Int): Int {
        return numberOne - numberTwo
    }

    fun cleanState() {
        println("clean state - done!")
    }
}
