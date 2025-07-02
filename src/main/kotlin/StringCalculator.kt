package org.example

class StringCalculator {
    fun add(input: String): Int {
        if (input.isEmpty()) {return 0}

        val delimiters = mutableListOf(',', '\n');
        val sum = input.split(*delimiters.toCharArray())
            .filter { it.isNotBlank() }
            .sumOf { it.toInt() }

        return sum;
    }
}