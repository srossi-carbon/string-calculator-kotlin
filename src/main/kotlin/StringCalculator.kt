package org.example

class StringCalculator {
    fun add(input: String): Int {
        if (input.isEmpty()) {return 0}

        val sum = input.split(',')
            .sumOf { it.toInt() }

        return sum;
    }
}