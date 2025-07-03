import org.example.CalculatorParsingResult
import kotlin.test.Test
import kotlin.test.assertEquals

class CalculatorParsingResultTest {
    @Test
    fun `result should have empty delimiter and return input as calculatorValues if only one value is given`() {
        val input = "2"
        val parsingResult = CalculatorParsingResult(input)

        val calculatorValues = parsingResult.calculatorValues;
        val customDelimiter = parsingResult.customDelimiter

        assertEquals(input, calculatorValues)
        assertEquals("", customDelimiter)
    }

    @Test
    fun `result should have empty delimiter and return input as calculatorValues if only values are given`() {
        val input = "2,3"
        val parsingResult = CalculatorParsingResult(input)

        val calculatorValues = parsingResult.calculatorValues;
        val customDelimiter = parsingResult.customDelimiter

        assertEquals(input, calculatorValues)
        assertEquals("", customDelimiter)
    }

    @Test
    fun `result should have empty delimiter and empty customValues if input is empty`() {
        val input = ""
        val parsingResult = CalculatorParsingResult(input)

        val calculatorValues = parsingResult.calculatorValues;
        val customDelimiter = parsingResult.customDelimiter

        assertEquals("", calculatorValues)
        assertEquals("", customDelimiter)
    }

    @Test
    fun `result should return custom delimiter and rest of input as calculatorValues if custom delimiter and values are given`() {
        val input = "//;\n2,3"
        val parsingResult = CalculatorParsingResult(input)

        val calculatorValues = parsingResult.calculatorValues;
        val customDelimiter = parsingResult.customDelimiter

        assertEquals(";", customDelimiter)
        assertEquals("2,3", calculatorValues)
    }

}