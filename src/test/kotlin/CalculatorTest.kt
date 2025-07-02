
import org.example.StringCalculator
import kotlin.test.Test
import kotlin.test.assertEquals

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
    fun `add returns sum of many values and consider \n as a delimiter`() {
        val calculator = StringCalculator()
        val input = "1\n2,3"

        val result = calculator.add(input)

        assertEquals(6, result)
    }

}