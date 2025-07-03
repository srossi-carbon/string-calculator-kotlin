import org.example.NegativeNumberException
import org.example.StringCalculator
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class CalculatorTest {
    @Test
    fun `add returns 0 for empty string`() {
        val calculator = StringCalculator()
        val input = ""

        val result = calculator.add(input)

        assertEquals(0, result)
    }

    @Test
    fun `add returns value for string containing only one value`() {
        val calculator = StringCalculator()
        val input = "1"

        val result = calculator.add(input)

        assertEquals(1, result)
    }

    @Test
    fun `add returns sum of two values for string containing two values`() {
        val calculator = StringCalculator()
        val input = "1,2"

        val result = calculator.add(input)

        assertEquals(3, result)
    }

    @Test
    fun `add returns sum of many values for string containing more than two values`() {
        val calculator = StringCalculator()
        val input = "1,2,3,4,5"

        val result = calculator.add(input)

        assertEquals(15, result)
    }

    @Test
    fun `add returns sum of many values and consider backslash n as a delimiter`() {
        val calculator = StringCalculator()
        val input = "1\n2,3"

        val result = calculator.add(input)

        assertEquals(6, result)
    }

    @Test
    fun `add returns sum of many values and consider a special delimiter`() {
        val calculator = StringCalculator()
        val input = "//;\n1,2;3"

        val result = calculator.add(input)

        assertEquals(6, result)
    }

    @Test
    fun `add should throw exception if one negative number is given`() {
        val calculator = StringCalculator()
        val input = "-5,2,9"

        val exception = assertFailsWith<NegativeNumberException> {
            calculator.add(input)
        }

        assertEquals("Les nombres négatifs ne sont pas autorisés", exception.message)
    }

    @Test
    fun `add should throw exception and give negative numbers if many negative numbers are given`() {
        val calculator = StringCalculator()
        val input = "-5,2,-10,9"


        val exception = assertFailsWith<NegativeNumberException> {
            calculator.add(input)
        }

        assertEquals("Les nombres négatifs ne sont pas autorisés : -5, -10", exception.message)
    }

}