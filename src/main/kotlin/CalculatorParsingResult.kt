package org.example

import java.util.regex.Pattern

class CalculatorParsingResult (calculatorInput: String) {
    val customDelimiter: String
    val calculatorValues: String


    init {
        val pattern = Pattern.compile("^//(.)\\n(.*)", Pattern.DOTALL)
        val matcher = pattern.matcher(calculatorInput)

        if (matcher.find()) {
            customDelimiter = matcher.group(1)
            calculatorValues = matcher.group(2)
        } else {
            customDelimiter = ""
            calculatorValues = calculatorInput
        }
    }
}

