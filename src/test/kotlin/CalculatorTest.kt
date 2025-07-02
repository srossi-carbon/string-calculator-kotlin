
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
}