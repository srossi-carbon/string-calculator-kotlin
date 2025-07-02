
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
    fun `add returns sum of two values for string containing two values separated by comma`() {
        val calculator = StringCalculator()
        val input = "1,2"

        val result = calculator.add(input)

        assertEquals(3, result)
    }

}