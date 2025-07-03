package org.example

import java.util.regex.Pattern

class StringCalculator {



    fun add(input: String): Int {
        if (input.isEmpty()) {return 0}

        val delimiters = mutableListOf(",", "\n")


        val parsingResult = CalculatorParsingResult(input)


        val customDelimiter = parsingResult.customDelimiter
        val calculatorValues = parsingResult.calculatorValues

        if (customDelimiter.isNotEmpty()) {
            delimiters.add(customDelimiter)
        }


        val sum = calculatorValues
            .split(*delimiters.toTypedArray())
            .filter { it.isNotBlank() }
            .sumOf { it.toInt() }

        return sum;
    }
}