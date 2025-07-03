package org.example

class StringCalculator {

    fun add(input: String): Int {
        if (input.isEmpty()) {return 0}

        val delimiters = mutableListOf(",", "\n")
        val parsingResult = CalculatorParsingResult(input)
        val customDelimiter = parsingResult.customDelimiter
        val calculatorValuesStr = parsingResult.calculatorValues

        if (customDelimiter.isNotEmpty()) {
            delimiters.add(customDelimiter)
        }

        val values = getValues(calculatorValuesStr, delimiters)
        val negativeNumbers = filterNegativeNumbers(values);

        if (negativeNumbers.isNotEmpty()) {
            throw NegativeNumberException(negativeNumbers)
        }

        return values.sum()
    }


    fun filterNegativeNumbers(values: List<Int>): List<Int> {
        return values.filter { it < 0 }
    }

    fun getValues(values: String, delimiters: MutableList<String>): List<Int> {
        return values
            .split(*delimiters.toTypedArray())
            .filter { it.isNotBlank() }
            .map { it.toInt() }
    }
}