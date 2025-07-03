package org.example

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

        return calculatorValues
            .split(*delimiters.toTypedArray())
            .filter { it.isNotBlank() }
            .sumOf { it.toInt() }
    }
}